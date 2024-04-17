package com.wreckingballsoftware.blackmailed.ui.gameplay.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayEvent
import com.wreckingballsoftware.blackmailed.ui.theme.blackmailedTypography
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions

@Composable
fun GameBar(
    timeRemaining: String,
    onEvent: (GameplayEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.then(
            Modifier
                .padding(horizontal = MaterialTheme.dimensions.padding)
                .padding(bottom = MaterialTheme.dimensions.paddingSmall),
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = timeRemaining,
            style = MaterialTheme.blackmailedTypography.headline,
        )
        Button(
            modifier = Modifier
                .width(MaterialTheme.dimensions.buttonWidth),
            onClick = { onEvent(GameplayEvent.SubmitBlackmailLetter) }
        ) {
            Text("Submit")
        }
    }
}

@Preview(name = "GameBar Preview", showBackground = true)
@Composable
fun GameBarPreview() {
    GameBar(
        timeRemaining = "1:23",
        onEvent = { },
    )
}
