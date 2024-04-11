package com.wreckingballsoftware.blackmailed.ui.roundresults.models

sealed interface RoundResultsNavigation {
    data object StartNextRound : RoundResultsNavigation
}
