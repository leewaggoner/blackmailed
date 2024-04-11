package com.wreckingballsoftware.blackmailed.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.blackmailed.ui.theme.blackmailedTypography
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions

@Composable
fun PromptCard(
    prompt: String,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(
        modifier = modifier,
        border = BorderStroke(MaterialTheme.dimensions.cardBorderWidth, Color.DarkGray),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimensions.padding)
                .verticalScroll(rememberScrollState()),

        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = prompt,
                style = MaterialTheme.blackmailedTypography.title,
            )
        }
    }
}

@Preview(name = "PromptCard Preview", showBackground = true)
@Composable
fun PromptCardPreview() {
    PromptCard(
        prompt = "Describe the day in the life of a forgetful wedding planner trying to organize a wedding with the help of their equally forgetful assistant."
    )
}
