package com.wreckingballsoftware.blackmailed.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.blackmailed.ui.theme.blackmailedTypography
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions

@Composable
fun BlackmailWord(
    word: String,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.then(
            Modifier
                .clickable { onClick(word) }
        ),
        shape = RoundedCornerShape(MaterialTheme.dimensions.wordCorner),
        border = BorderStroke(MaterialTheme.dimensions.cardBorderWidth, Color.DarkGray),
        elevation = CardDefaults.cardElevation(
            defaultElevation = MaterialTheme.dimensions.cardElevation
        ),
    ) {
        Text(
            modifier = Modifier.padding(MaterialTheme.dimensions.paddingVerySmall),
            text = word,
            style = MaterialTheme.blackmailedTypography.body
        )
    }
}

@Preview(name = "BlackmailWord Preview", showBackground = true)
@Composable
fun BlackmailWordPreview() {
    BlackmailWord(
        word = "blackmail",
        onClick = { }
    )
}
