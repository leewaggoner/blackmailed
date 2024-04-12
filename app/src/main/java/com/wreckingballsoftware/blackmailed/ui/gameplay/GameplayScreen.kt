package com.wreckingballsoftware.blackmailed.ui.gameplay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wreckingballsoftware.blackmailed.ui.compose.BlackmailLetter
import com.wreckingballsoftware.blackmailed.ui.compose.BlackmailWordTray
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
                .weight(0.15f)
                .padding(horizontal = MaterialTheme.dimensions.padding)
                .padding(bottom = MaterialTheme.dimensions.paddingSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "2:00",
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
        PromptCard(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .padding(bottom = MaterialTheme.dimensions.paddingSmall),
            prompt = state.prompt,
        )
        BlackmailLetter(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .padding(bottom = MaterialTheme.dimensions.paddingSmall),
            onClick = { word ->
                onEvent(GameplayEvent.BlackmailLetterClicked(word))
            },
            letter = state.blackmailLetter,
        )
        BlackmailWordTray(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.45f),
            onClick = { word ->
                onEvent(GameplayEvent.BlackmailWordTrayClicked(word))
            },
            words = state.blackmailTray,
        )
    }
}

@Preview(name = "GameplayScreenContent Preview", showBackground = true)
@Composable
fun GameplayScreenContentPreview() {
    GameplayScreenContent(
        state = GameplayState(
            prompt = "Describe the day in the life of a forgetful wedding planner trying to organize a wedding with the help of their equally forgetful assistant.",
            blackmailLetter = listOf("I", "am", "a", "very", "large", "blackmail", "letter", "for", "you", "to", "read", "and", "enjoy", "forever", "and", "ever", "and", "ever", "and", "ever", "and", "ever"),
            blackmailTray = listOf(
                "I",
                "always",
                "am",
                "art",
                "away",
                "bad",
                "bank",
                "beam",
                "bear",
                "board",
                "bomb",
                "brain",
                "bulbous",
                "buy",
                "chaos",
                "check",
                "collect",
                "compete",
                "could",
                "crowd",
                "crush",
                "curious",
                "dangerous",
                "dark",
                "decide",
                "decrease",
                "did",
                "don't",
                "drip",
                "excite",
                "fiend",
                "gigantic",
                "give",
                "grip",
                "heart",
                "illness",
                "insult",
                "jerk",
                "joke",
                "let",
                "liar",
                "lucky",
                "ly",
                "mingle",
                "my",
                "object",
                "person",
                "ping",
                "please",
                "queen",
                "righteous",
                "she",
                "shine",
                "so",
                "spooky",
                "squeeze",
                "stress",
                "sweet",
                "territory",
                "tip",
                "too",
                "tough",
                "treasure",
                "vacation",
                "was",
                "wear",
                "weird",
                "where",
                "woman",
                "wreck",
            ),
        ),
        onEvent = { },
    )
}
