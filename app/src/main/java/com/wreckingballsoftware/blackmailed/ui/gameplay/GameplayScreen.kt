package com.wreckingballsoftware.blackmailed.ui.gameplay

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.toAndroidDragEvent
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wreckingballsoftware.blackmailed.ui.compose.BlackmailLetter
import com.wreckingballsoftware.blackmailed.ui.compose.BlackmailWordTray
import com.wreckingballsoftware.blackmailed.ui.compose.PromptCard
import com.wreckingballsoftware.blackmailed.ui.compose.transferToLetterAction
import com.wreckingballsoftware.blackmailed.ui.compose.transferToTrayAction
import com.wreckingballsoftware.blackmailed.ui.gameplay.compose.GameBar
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayEvent
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayNavigation
import com.wreckingballsoftware.blackmailed.ui.gameplay.models.GameplayState
import com.wreckingballsoftware.blackmailed.ui.navigation.NavGraph
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
            GameplayNavigation.Submit -> navGraph.navigateToRoundResultsScreen(
                viewModel.getPlayerName(),
                viewModel.state.prompt,
                viewModel.getLetter(),
            )
        }
    }

    GameplayScreenContent(
        state = viewModel.state,
        onEvent = viewModel::onEvent,
    )
}

@OptIn(ExperimentalFoundationApi::class)
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
        GameBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.dimensions.gameBarHeight),
            timeRemaining = state.timeRemaining,
            onEvent = onEvent,
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            PromptCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.dimensions.promptHeight)
                    .padding(bottom = MaterialTheme.dimensions.paddingSmall),
                prompt = state.prompt,
            )
            BlackmailLetter(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.dimensions.letterTrayHeight)
                    .padding(bottom = MaterialTheme.dimensions.paddingSmall)
                    .dragAndDropTarget(
                        shouldStartDragAndDrop = { event ->
                            event.toAndroidDragEvent().clipDescription.label == transferToLetterAction
                        },
                        target = object : DragAndDropTarget {
                            override fun onDrop(event: DragAndDropEvent): Boolean {
                                if(event.toAndroidDragEvent().clipDescription.label == transferToLetterAction) {
                                    onEvent(
                                        GameplayEvent.MoveWordToLetter(
                                            index = event
                                                .toAndroidDragEvent()
                                                .clipData.getItemAt(0).text.toString().toInt()
                                        )
                                    )
                                }
                                return true
                            }
                        }
                    ),
                letter = state.blackmailLetter,
                draggable = true,
                transferAction = transferToTrayAction,
                onClick = { index ->
                    onEvent(GameplayEvent.MoveWordToTray(index = index))
                },
            )
            BlackmailWordTray(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.dimensions.wordTrayHeight)
                    .dragAndDropTarget(
                        shouldStartDragAndDrop = { event ->
                            event.toAndroidDragEvent().clipDescription.label == transferToTrayAction
                        },
                        target = object : DragAndDropTarget {
                            override fun onDrop(event: DragAndDropEvent): Boolean {
                                if(event.toAndroidDragEvent().clipDescription.label == transferToTrayAction) {
                                    onEvent(
                                        GameplayEvent.MoveWordToTray(
                                            index = event
                                                .toAndroidDragEvent()
                                                .clipData.getItemAt(0).text.toString().toInt()
                                        )
                                    )
                                }
                                return true
                            }
                        }
                    ),
                words = state.blackmailTray,
                draggable = true,
                transferAction = transferToLetterAction,
                onClick = { index ->
                    onEvent(GameplayEvent.MoveWordToLetter(index = index))
                },
            )
        }
    }
}

@Preview(name = "GameplayScreenContent Preview", showBackground = true)
@Composable
fun GameplayScreenContentPreview() {
    GameplayScreenContent(
        state = GameplayState(
            timeRemaining = "00:00",
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
