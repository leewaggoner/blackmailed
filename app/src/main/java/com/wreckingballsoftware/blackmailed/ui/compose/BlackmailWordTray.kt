package com.wreckingballsoftware.blackmailed.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BlackmailWordTray(
    words: List<String>,
    onClick: (Int) -> Unit,
    transferAction: String,
    draggable: Boolean,
    modifier: Modifier = Modifier,
) {
    BlackmailLetter(
        modifier = modifier,
        letter = words,
        onClick = onClick,
        transferAction = transferAction,
        draggable = draggable,
    )
}

@Preview(name = "BlackmailWordTray Preview", showBackground = true)
@Composable
fun BlackmailWordTrayPreview() {
    BlackmailWordTray(
        words = listOf(
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
        onClick = { },
        transferAction = transferToLetterAction,
        draggable = false,
    )
}