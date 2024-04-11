package com.wreckingballsoftware.blackmailed.ui.roundresults

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wreckingballsoftware.blackmailed.ui.compose.PromptCard
import com.wreckingballsoftware.blackmailed.ui.navigation.NavGraph
import com.wreckingballsoftware.blackmailed.ui.roundresults.compose.PlayerLetter
import com.wreckingballsoftware.blackmailed.ui.roundresults.models.RoundResultsEvent
import com.wreckingballsoftware.blackmailed.ui.roundresults.models.RoundResultsNavigation
import com.wreckingballsoftware.blackmailed.ui.roundresults.models.RoundResultsState
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions
import org.koin.androidx.compose.getViewModel

@Composable
fun RoundResultsScreen(
    navGraph: NavGraph,
    viewModel: RoundResultsViewModel = getViewModel(),
) {
    val navigation = viewModel.navigation.collectAsStateWithLifecycle(null)
    navigation.value?.let { nav ->
        when (nav) {
            RoundResultsNavigation.StartNextRound ->navGraph.navigateToGamePlayScreen()
        }
    }

    RoundResultsScreenContent(
        state = viewModel.state,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun RoundResultsScreenContent(
    state: RoundResultsState,
    onEvent: (RoundResultsEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimensions.padding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = MaterialTheme.dimensions.padding)
                .weight(1.0f)
        ) {
            PromptCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
                    .padding(bottom = MaterialTheme.dimensions.padding),
                prompt = state.prompt,
            )
            state.players.forEachIndexed { index, player ->
                PlayerLetter(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
                    .padding(bottom = MaterialTheme.dimensions.padding),
                    playerName = player,
                    playerWon = true,
                    letter = state.blackmailLetters[index]
                )
            }
        }
        Button(
            modifier = Modifier
                .padding(vertical = MaterialTheme.dimensions.padding),
            onClick = { onEvent(RoundResultsEvent.OnStartNextRound) }
        ) {
            Text("Play Again")
        }
    }
}

@Preview(name = "ResultsScreenContent Preview", showBackground = true)
@Composable
fun RoundResultsScreenContentPreview() {
    RoundResultsScreenContent(
        state = RoundResultsState(
            prompt = "Describe the day in the life of a forgetful wedding planner trying to organize a wedding with the help of their equally forgetful assistant.",
            blackmailLetters = listOf(
                listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
                listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
                listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
                listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
            )
        ),
        onEvent = { }
    )
}
