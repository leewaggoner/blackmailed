package com.wreckingballsoftware.blackmailed.ui.gameplay

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GameplayScreen() {
    GameplayScreenContent()
}

@Composable
fun GameplayScreenContent() {
    Text("Gameplay")
}

@Preview(name = "GameplayScreenContent Preview", showBackground = true)
@Composable
fun GameplayScreenContentPreview() {
    GameplayScreenContent()
}