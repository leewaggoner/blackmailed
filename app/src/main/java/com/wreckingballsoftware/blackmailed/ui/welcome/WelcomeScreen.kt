package com.wreckingballsoftware.blackmailed.ui.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.wreckingballsoftware.blackmailed.ui.navigation.NavGraph

@Composable
fun WelcomeScreen(
    navGraph: NavGraph,
) {
    WelcomeScreenContent(
        navGraph = navGraph,
    )
}

@Composable
fun WelcomeScreenContent(
    navGraph: NavGraph,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Welcome to Blackmailed")
        Button(onClick = { navGraph.navigateToGamePlayScreen() }) {
            Text("Start")
        }
    }
}

@Preview(name = "WelcomeScreenContent Preview", showBackground = true)
@Composable
fun WelcomeScreenContentPreview() {
    WelcomeScreenContent(
        navGraph = NavGraph(rememberNavController())
    )
}