package com.wreckingballsoftware.blackmailed.ui.welcome

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wreckingballsoftware.blackmailed.ui.welcome.models.WelcomeEvent
import com.wreckingballsoftware.blackmailed.ui.welcome.models.WelcomeNavigation
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val handle: SavedStateHandle,
) : ViewModel() {
    val navigation = MutableSharedFlow<WelcomeNavigation>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    fun onEvent(event: WelcomeEvent) {
        when (event) {
            WelcomeEvent.OnPlayPressed -> {
                viewModelScope.launch {
                    navigation.emit(WelcomeNavigation.Play)
                }
            }
        }
    }
}