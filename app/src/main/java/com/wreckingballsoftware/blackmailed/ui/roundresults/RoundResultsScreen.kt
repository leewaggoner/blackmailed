package com.wreckingballsoftware.blackmailed.ui.roundresults

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions
import org.koin.androidx.compose.getViewModel

@Composable
fun RoundResultsScreen(
    navGraph: NavGraph,
    players: List<String>,
    prompt: String,
    letters: List<List<String>>,
    viewModel: RoundResultsViewModel = getViewModel(),
) {
    val navigation = viewModel.navigation.collectAsStateWithLifecycle(null)
    navigation.value?.let { nav ->
        when (nav) {
            RoundResultsNavigation.StartNextRound ->navGraph.navigateToGamePlayScreen()
        }
    }

    RoundResultsScreenContent(
        players = players,
        prompt = prompt,
        letters = letters,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun RoundResultsScreenContent(
    players: List<String>,
    prompt: String,
    letters: List<List<String>>,
    onEvent: (RoundResultsEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MaterialTheme.dimensions.padding)
            .padding(horizontal = MaterialTheme.dimensions.padding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.0f),
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
            ) {
                PromptCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MaterialTheme.dimensions.promptHeight)
                        .padding(bottom = MaterialTheme.dimensions.padding),
                    prompt = prompt,
                )
                players.forEachIndexed { index, player ->
                    PlayerLetter(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(MaterialTheme.dimensions.letterTrayHeight)
                            .padding(bottom = MaterialTheme.dimensions.padding),
                        playerName = player,
                        playerWon = true,
                        letter = letters[index]
                    )
                }
            }
        }
        Button(
            modifier = Modifier
                .padding(vertical = MaterialTheme.dimensions.paddingSmall),
            onClick = { onEvent(RoundResultsEvent.OnStartNextRound) },
        ) {
            Text("Play Again")
        }
    }
}

@Preview(name = "ResultsScreenContent Preview", showBackground = true)
@Composable
fun RoundResultsScreenContentPreview() {
    RoundResultsScreenContent(
        players = listOf("Player1", "Player2", "Player3", "Player4"),
        prompt = "Describe the day in the life of a forgetful wedding planner trying to organize a wedding with the help of their equally forgetful assistant.",
        letters = listOf(
            listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
            listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
            listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
            listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
        ),
        onEvent = { }
    )
}
