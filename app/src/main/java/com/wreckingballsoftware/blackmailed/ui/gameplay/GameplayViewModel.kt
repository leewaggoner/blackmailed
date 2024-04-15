package com.wreckingballsoftware.blackmailed.ui.gameplay

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.blackmailed.data.repos.BlackmailedAssetsRepo
import com.wreckingballsoftware.blackmailed.data.repos.GameTimer
import com.wreckingballsoftware.blackmailed.data.repos.MAX_TIME
import com.wreckingballsoftware.blackmailed.extensions.listJsonEncode
import com.wreckingballsoftware.blackmailed.extensions.listOfListsJsonEncode
import com.wreckingballsoftware.blackmailed.extensions.millisToTimeString
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayEvent
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayNavigation
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class GameplayViewModel(
    handle: SavedStateHandle,
    private val assetsRepo: BlackmailedAssetsRepo,
    private val gameTimer: GameTimer,
) : ViewModel() {
    @OptIn(SavedStateHandleSaveableApi::class)
    var state by handle.saveable {
        mutableStateOf(GameplayState())
    }

    val navigation = MutableSharedFlow<GameplayNavigation>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    init {
        viewModelScope.launch {
            assetsRepo.getBlackmailPrompts()
            onEvent(
                GameplayEvent.ResetGameplayScreen(
                    prompt = assetsRepo.getNextPrompt(),
                    wordList = assetsRepo.getBlackmailWords().map { it.word }
                )
            )
        }
    }

    fun onEvent(event: GameplayEvent) {
        when (event) {
            is GameplayEvent.ResetGameplayScreen -> {
                gameTimer.startTimer(
                    onTick = { timeRemaining ->
                        val remaining = timeRemaining.millisToTimeString()
                        state = state.copy(timeRemaining = remaining)
                    },
                    onFinish = {
                        viewModelScope.launch {
                            navigation.emit(GameplayNavigation.Submit)
                        }
                    }
                )
                state = GameplayState(
                    timeRemaining = MAX_TIME.millisToTimeString(),
                    prompt = event.prompt,
                    blackmailTray = event.wordList
                )
            }
            GameplayEvent.SubmitBlackmailLetter -> {
                gameTimer.onFinish()
                viewModelScope.launch {
                    navigation.emit(GameplayNavigation.Submit)
                }
            }
            is GameplayEvent.BlackmailLetterClicked -> {
                state = state.copy(
                    blackmailLetter = removeWord(
                        state.blackmailLetter,
                        event.word,
                    ),
                    blackmailTray = addWord(
                        state.blackmailTray,
                        event.word,
                        addToFront = true
                    )
                )
            }
            is GameplayEvent.BlackmailWordTrayClicked -> {
                state = state.copy(
                    blackmailTray = removeWord(
                        wordList = state.blackmailTray,
                        word =  event.word,
                    ),
                    blackmailLetter = addWord(
                        state.blackmailLetter,
                        event.word,
                    )
                )
            }
        }
    }

    fun getPlayerName() : String = listOf("Player1").listJsonEncode()

    fun getLetter() : String  = listOf(state.blackmailLetter).listOfListsJsonEncode()

    private fun addWord(
        wordList: List<String>,
        word: String,
        addToFront: Boolean = false
    ) : List<String> {
        val tray = wordList.toMutableList().apply {
            if (addToFront) {
                add(0, word)
            } else {
                add(word)
            }
        }
        return tray
    }

    private fun removeWord(wordList: List<String>, word: String) : List<String> {
        val tray = wordList.toMutableList().apply {
            remove(word)
        }
        return tray
    }
}
