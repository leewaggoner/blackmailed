package com.wreckingballsoftware.blackmailed.ui.gameplay.models

sealed interface GameplayNavigation {
    data object Submit : GameplayNavigation
}
