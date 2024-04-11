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
        }
    }
}
