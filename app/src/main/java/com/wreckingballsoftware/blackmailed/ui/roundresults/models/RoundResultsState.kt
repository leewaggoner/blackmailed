package com.wreckingballsoftware.blackmailed.ui.roundresults.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoundResultsState(
    val prompt: String = "",
    val blackmailLetters: List<List<String>> = listOf(listOf()),
    val players: List<String> = listOf(),
) : Parcelable
