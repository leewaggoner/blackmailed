package com.wreckingballsoftware.blackmailed.ui.welcome.models

sealed interface WelcomeEvents {
    data object OnPlayPressed : WelcomeEvents
}