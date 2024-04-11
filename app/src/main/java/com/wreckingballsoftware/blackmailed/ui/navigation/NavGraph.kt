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
    val navigateToRoundResultsScreen: () -> Unit = {
        navController.navigate(
            Destinations.RoundResultsScreen
        ) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}
