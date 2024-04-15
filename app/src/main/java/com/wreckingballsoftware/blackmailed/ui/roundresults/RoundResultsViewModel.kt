package com.wreckingballsoftware.blackmailed.ui.roundresults

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wreckingballsoftware.blackmailed.ui.roundresults.models.RoundResultsEvent
import com.wreckingballsoftware.blackmailed.ui.roundresults.models.RoundResultsNavigation
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class RoundResultsViewModel(
    handle: SavedStateHandle,
) : ViewModel() {
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
