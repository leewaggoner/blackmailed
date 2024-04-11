package com.wreckingballsoftware.blackmailed.ui.roundresults.models

sealed interface RoundResultsEvent {
    data object OnStartNextRound : RoundResultsEvent
}
