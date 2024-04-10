package com.wreckingballsoftware.blackmailed.ui.welcome.models

sealed interface WelcomeNavigation {
    data object Play : WelcomeNavigation
}