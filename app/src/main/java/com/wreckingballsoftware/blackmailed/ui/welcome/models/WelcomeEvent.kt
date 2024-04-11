package com.wreckingballsoftware.blackmailed.ui.welcome.models

sealed interface WelcomeEvent {
    data object OnPlayPressed : WelcomeEvent
}