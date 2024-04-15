package com.wreckingballsoftware.blackmailed.ui.gameplay.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameplayState(
    val timeRemaining: String = "",
    val prompt: String = "",
    val blackmailLetter: List<String> = emptyList(),
    val blackmailTray: List<String> = emptyList(),
) : Parcelable
