package com.wreckingballsoftware.blackmailed.ui.gameplay.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameplayState(
    val timeRemaining: String = "2:00",
    val prompt: String = "Describe the day in the life of a forgetful wedding planner trying to organize a wedding with the help of their equally forgetful assistant.",
    val wordList: List<String> = emptyList(),
    val blackmailLetter: List<String> = listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
) : Parcelable
