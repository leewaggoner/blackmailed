package com.wreckingballsoftware.blackmailed.ui.roundresults.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.blackmailed.ui.compose.BlackmailLetter
import com.wreckingballsoftware.blackmailed.ui.theme.blackmailedTypography
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PlayerLetter(
    modifier: Modifier = Modifier,
    playerName: String,
    playerWon: Boolean,
    letter: List<String>,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MaterialTheme.dimensions.paddingSmall)
                .padding(horizontal = MaterialTheme.dimensions.padding),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = if (playerWon) "Winner!" else "",
                style = MaterialTheme.blackmailedTypography.winner
            )
            Text(
                text = playerName,
                style = MaterialTheme.blackmailedTypography.title
            )
        }
        BlackmailLetter(
            letter = letter,
            onClick = { }
        )
    }
}

@Preview(name = "PlayerLetter Preview", showBackground = true)
@Composable
fun PlayerLetterPreview() {
    PlayerLetter(
        playerName = "Player 1",
        playerWon = true,
        letter = listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever")
    )
}
