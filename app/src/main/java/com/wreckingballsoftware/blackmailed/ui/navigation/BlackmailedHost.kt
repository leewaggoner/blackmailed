package com.wreckingballsoftware.blackmailed.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wreckingballsoftware.blackmailed.extensions.listJsonDecode
import com.wreckingballsoftware.blackmailed.extensions.listOfListsJsonDecode
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

        composable(
            route = Destinations.RoundResultsScreen,
            arguments = listOf(
                navArgument("players") { type = NavType.StringType },
                navArgument("prompt") { type = NavType.StringType },
                navArgument("letters") { type = NavType.StringType },
            )
        ) { backstackEntry ->
            val players: List<String> =
                (backstackEntry.arguments?.getString("players") ?: "[]").listJsonDecode()
            val prompt: String = backstackEntry.arguments?.getString("prompt") ?: ""
            val letters: List<List<String>> =
                (backstackEntry.arguments?.getString("letters") ?: "[[]]").listOfListsJsonDecode()
            RoundResultsScreen(
                navGraph = navGraph,
                players = players,
                prompt = prompt,
                letters = letters,
            )
        }
    }
}
