package com.wreckingballsoftware.blackmailed.ui.welcome

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wreckingballsoftware.blackmailed.ui.welcome.models.WelcomeEvents
import com.wreckingballsoftware.blackmailed.ui.welcome.models.WelcomeNavigation
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class WelcomeViewModel(
    handle: SavedStateHandle,
) : ViewModel() {
    val navigation = MutableSharedFlow<WelcomeNavigation>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    fun onEvent(event: WelcomeEvents) {
        when (event) {
            WelcomeEvents.OnPlayPressed -> {
                viewModelScope.launch {
                    navigation.emit(WelcomeNavigation.Play)
                }
            }
        }
    }
}