package com.wreckingballsoftware.blackmailed.ui.welcome

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.blackmailed.ui.Greeting

@Composable
fun WelcomeScreen() {
    WelcomeScreenContent()
}

@Composable
fun WelcomeScreenContent() {
    Text("Welcome to Blackmailed")
}

@Preview(name = "WelcomeScreenContent Preview", showBackground = true)
@Composable
fun WelcomeScreenContentPreview() {
    WelcomeScreenContent()
}