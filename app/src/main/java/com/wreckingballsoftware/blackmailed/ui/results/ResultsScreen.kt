package com.wreckingballsoftware.blackmailed.ui.results

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ResultsScreen() {
    ResultsScreenContent()
}

@Composable
fun ResultsScreenContent() {
    Text("Results")
}

@Preview(name = "ResultsScreenContent Preview", showBackground = true)
@Composable
fun ResultsScreenContentPreview() {
    ResultsScreenContent()
}