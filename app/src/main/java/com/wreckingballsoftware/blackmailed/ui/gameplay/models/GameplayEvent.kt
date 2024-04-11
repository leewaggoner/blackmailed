package com.wreckingballsoftware.blackmailed.ui.gameplay.models

sealed interface GameplayEvent {
    data object ResetGameplayScreen : GameplayEvent
    data object SubmitBlackmailLetter : GameplayEvent
}
