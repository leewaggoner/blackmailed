package com.wreckingballsoftware.blackmailed.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BlackmailLetterCard(
    letter: List<String>,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(
        modifier = modifier,
        border = BorderStroke(MaterialTheme.dimensions.cardBorderWidth, Color.DarkGray),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),

            ) {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = MaterialTheme.dimensions.padding),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.padding),
            ) {
                letter.forEach { word ->
                    BlackmailWord(
                        modifier = Modifier.padding(vertical = MaterialTheme.dimensions.paddingSmall),
                        word = word,
                    )
                }
            }
        }
    }
}

@Preview(name = "BlackmailLetterCard Preview", showBackground = true)
@Composable
fun BlackmailLetterCardPreview() {
    BlackmailLetterCard(
        letter = listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever")
    )
}
