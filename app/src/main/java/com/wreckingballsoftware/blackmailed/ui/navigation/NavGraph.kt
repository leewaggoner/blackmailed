package com.wreckingballsoftware.blackmailed.ui.navigation

import androidx.navigation.NavController

class NavGraph(navController: NavController) {
    val navigateToWelcomeScreen: () -> Unit = {
        navController.navigate(
            Destinations.WelcomeScreen
        ) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    val navigateToGamePlayScreen: () -> Unit = {
        navController.navigate(
            Destinations.GamePlayScreen
        ) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    val navigateToRoundResultsScreen:
                (String, String, String) -> Unit = { players, prompt, letters ->
        navController.navigate(
            Destinations.RoundResultsScreen.replace(
                oldValue = "{players}",
                newValue = players,
            ).replace(
                oldValue = "{prompt}",
                newValue = prompt,
            ).replace(
                oldValue = "{letters}",
                newValue = letters,
            )
        ) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}
