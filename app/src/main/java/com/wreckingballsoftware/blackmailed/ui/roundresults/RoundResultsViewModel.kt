package com.wreckingballsoftware.blackmailed.ui.roundresults

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.blackmailed.ui.roundresults.models.RoundResultsEvent
import com.wreckingballsoftware.blackmailed.ui.roundresults.models.RoundResultsNavigation
import com.wreckingballsoftware.blackmailed.ui.roundresults.models.RoundResultsState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class RoundResultsViewModel(
    handle: SavedStateHandle,
) : ViewModel() {
    @OptIn(SavedStateHandleSaveableApi::class)
    var state by handle.saveable {
        mutableStateOf(RoundResultsState())
    }

    val navigation = MutableSharedFlow<RoundResultsNavigation>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    fun onEvent(event: RoundResultsEvent) {
        when (event) {
            RoundResultsEvent.OnStartNextRound -> {
                viewModelScope.launch {
                    navigation.emit(RoundResultsNavigation.StartNextRound)
                }
            }
        }
    }
}
