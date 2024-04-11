package com.wreckingballsoftware.blackmailed.di

import com.wreckingballsoftware.blackmailed.ui.gameplay.GameplayViewModel
import com.wreckingballsoftware.blackmailed.ui.roundresults.RoundResultsViewModel
import com.wreckingballsoftware.blackmailed.ui.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        WelcomeViewModel(
            handle = get(),
        )
    }
    viewModel {
        GameplayViewModel(
            handle = get(),
        )
    }
    viewModel {
        RoundResultsViewModel(
            handle = get(),
        )
    }
}
