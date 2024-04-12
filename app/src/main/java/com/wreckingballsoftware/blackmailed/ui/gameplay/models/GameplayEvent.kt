package com.wreckingballsoftware.blackmailed.ui.gameplay.models

sealed interface GameplayEvent {
    data object ResetGameplayScreen : GameplayEvent
    data object SubmitBlackmailLetter : GameplayEvent
    data class BlackmailLetterClicked(val word: String) : GameplayEvent
    data class BlackmailWordTrayClicked(val word: String) : GameplayEvent
}
