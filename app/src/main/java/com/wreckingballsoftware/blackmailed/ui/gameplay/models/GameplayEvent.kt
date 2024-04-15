package com.wreckingballsoftware.blackmailed.ui.gameplay.models

sealed interface GameplayEvent {
    data class ResetGameplayScreen(val prompt: String, val wordList: List<String>) : GameplayEvent
    data object SubmitBlackmailLetter : GameplayEvent
    data class BlackmailLetterClicked(val word: String) : GameplayEvent
    data class BlackmailWordTrayClicked(val word: String) : GameplayEvent
}
