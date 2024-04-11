package com.wreckingballsoftware.blackmailed.ui.gameplay

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wreckingballsoftware.blackmailed.ui.compose.BlackmailLetterCard
import com.wreckingballsoftware.blackmailed.ui.compose.PromptCard
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayEvent
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayNavigation
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayState
import com.wreckingballsoftware.blackmailed.ui.navigation.NavGraph
import com.wreckingballsoftware.blackmailed.ui.theme.blackmailedTypography
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions
import org.koin.androidx.compose.getViewModel

@Composable
fun GameplayScreen(
    navGraph: NavGraph,
    viewModel: GameplayViewModel = getViewModel(),
) {
    val navigation = viewModel.navigation.collectAsStateWithLifecycle(null)
    navigation.value?.let { nav ->
        when (nav) {
            GameplayNavigation.Submit ->navGraph.navigateToRoundResultsScreen()
        }
    }

    GameplayScreenContent(
        state = viewModel.state,
        onEvent = viewModel::onEvent,
    )
}

@Composable
fun GameplayScreenContent(
    state: GameplayState,
    onEvent: (GameplayEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimensions.padding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = MaterialTheme.dimensions.padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "2:00",
                style = MaterialTheme.blackmailedTypography.headline,
            )
            Button(
                onClick = { onEvent(GameplayEvent.SubmitBlackmailLetter) }
            ) {
                Text("Submit")
            }
        }
        PromptCard(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(bottom = MaterialTheme.dimensions.padding),
            prompt = state.prompt,
        )
        BlackmailLetterCard(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .padding(bottom = MaterialTheme.dimensions.padding),
            letter = state.blackmailLetter,
        )
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f),
            border = BorderStroke(2.dp, Color.DarkGray),
        ) {

        }
    }
}

@Preview(name = "GameplayScreenContent Preview", showBackground = true)
@Composable
fun GameplayScreenContentPreview() {
    GameplayScreenContent(
        state = GameplayState(
            prompt = "Describe the day in the life of a forgetful wedding planner trying to organize a wedding with the help of their equally forgetful assistant.",
            blackmailLetter = listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever")
        ),
        onEvent = { },
    )
}
