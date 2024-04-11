package com.wreckingballsoftware.blackmailed.ui.roundresults.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoundResultsState(
    val prompt: String = "Describe the day in the life of a forgetful wedding planner trying to organize a wedding with the help of their equally forgetful assistant.",
    val blackmailLetters: List<List<String>> = listOf(
        listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
        listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
        listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
        listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
    ),
    val players: List<String> = listOf("Player 1", "Player 2", "Player 3", "Player 4"),
) : Parcelable
