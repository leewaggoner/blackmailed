package com.wreckingballsoftware.blackmailed.ui.gameplay

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
fun GameplayScreen(
    navGraph: NavGraph,
) {
    GameplayScreenContent(
        navGraph = navGraph,
    )
}

@Composable
fun GameplayScreenContent(
    navGraph: NavGraph,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Gameplay")
        Button(onClick = { navGraph.navigateToResultsScreen() }) {
            Text("Results")
        }
    }
}

@Preview(name = "GameplayScreenContent Preview", showBackground = true)
@Composable
fun GameplayScreenContentPreview() {
    GameplayScreenContent(
        navGraph = NavGraph(rememberNavController())
    )
}