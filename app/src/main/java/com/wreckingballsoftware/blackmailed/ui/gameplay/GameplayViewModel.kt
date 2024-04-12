package com.wreckingballsoftware.blackmailed.ui.gameplay

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayEvent
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayNavigation
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class GameplayViewModel(
    handle: SavedStateHandle,
) : ViewModel() {
    @OptIn(SavedStateHandleSaveableApi::class)
    var state by handle.saveable {
        mutableStateOf(GameplayState())
    }

    val navigation = MutableSharedFlow<GameplayNavigation>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    fun onEvent(event: GameplayEvent) {
        when (event) {
            GameplayEvent.ResetGameplayScreen -> {
                state = GameplayState()
            }
            GameplayEvent.SubmitBlackmailLetter -> {
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
