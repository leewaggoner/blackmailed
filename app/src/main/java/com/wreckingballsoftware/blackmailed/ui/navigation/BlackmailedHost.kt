package com.wreckingballsoftware.blackmailed.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wreckingballsoftware.blackmailed.ui.gameplay.GameplayScreen
import com.wreckingballsoftware.blackmailed.ui.roundresults.RoundResultsScreen
import com.wreckingballsoftware.blackmailed.ui.welcome.WelcomeScreen

@Composable
fun BlackmailedHost() {
    val navController = rememberNavController()
    val navGraph = remember(navController) { NavGraph(navController) }

    val startDestination = Destinations.WelcomeScreen

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Destinations.WelcomeScreen) {
            WelcomeScreen(navGraph = navGraph)
        }

        composable(route = Destinations.GamePlayScreen) {
            GameplayScreen(navGraph = navGraph)
        }

        composable(route = Destinations.RoundResultsScreen) {
            RoundResultsScreen(navGraph = navGraph)
        }
    }
}
