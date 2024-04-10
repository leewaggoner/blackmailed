package com.wreckingballsoftware.blackmailed.ui.results

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
fun ResultsScreen(
    navGraph: NavGraph,
) {
    ResultsScreenContent(
        navGraph = navGraph,
    )
}

@Composable
fun ResultsScreenContent(
    navGraph: NavGraph,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Results")
        Button(onClick = { navGraph.navigateToWelcomeScreen() }) {
            Text("Play Again")
        }
    }
}

@Preview(name = "ResultsScreenContent Preview", showBackground = true)
@Composable
fun ResultsScreenContentPreview() {
    ResultsScreenContent(
        navGraph = NavGraph(rememberNavController())
    )
}