package com.wreckingballsoftware.blackmailed.ui.gameplay.models

sealed interface GameplayEvent {
    data class ResetGameplayScreen(val prompt: String, val wordList: List<String>) : GameplayEvent
    data object SubmitBlackmailLetter : GameplayEvent
    data class MoveWordToTray(val word: String) : GameplayEvent
    data class MoveWordToLetter(val word: String) : GameplayEvent
}
