package com.wreckingballsoftware.blackmailed.di

import androidx.room.Room
import com.wreckingballsoftware.blackmailed.data.database.BlackmailedDb
import com.wreckingballsoftware.blackmailed.data.repos.BlackmailedAssetsRepo
import com.wreckingballsoftware.blackmailed.data.repos.GameTimer
import com.wreckingballsoftware.blackmailed.ui.gameplay.GameplayViewModel
import com.wreckingballsoftware.blackmailed.ui.roundresults.RoundResultsViewModel
import com.wreckingballsoftware.blackmailed.ui.welcome.WelcomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

const val DB_NAME = "blackmailed"

val appModule = module {
    viewModel {
        WelcomeViewModel(
            handle = get(),
        )
    }
    viewModel {
        GameplayViewModel(
            handle = get(),
            assetsRepo = get(),
            gameTimer = get(),
        )
    }
    viewModel {
        RoundResultsViewModel(
            handle = get(),
        )
    }

    single {
        GameTimer()
    }

    single {
        BlackmailedAssetsRepo(
            blackmailWordsDao = get(),
            blackmailPromptsDao = get(),
        )
    }

    single {
        val database = get<BlackmailedDb>()
        database.getBlackmailWordsDao()
    }

    single {
        val database = get<BlackmailedDb>()
        database.getBlackmailPromptsDao()
    }

    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = BlackmailedDb::class.java,
            name = DB_NAME,
        )
            .createFromAsset("databases/$DB_NAME.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
