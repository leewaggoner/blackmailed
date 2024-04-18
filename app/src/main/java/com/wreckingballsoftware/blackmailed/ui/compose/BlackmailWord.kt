package com.wreckingballsoftware.blackmailed.ui.compose

import android.content.ClipData
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.blackmailed.ui.theme.blackmailedTypography
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions

const val transferToLetterAction = "action_wordToLetterAction"
const val transferToTrayAction = "action_wordToTrayAction"


/**
 * A single word in the BlackmailLetter
 *
 * Note: I added the index because the draggable was giving me the same word every time, even though
 * the word displayed was different. For example: if I dragged and dropped the second element,
 * (A, B, C), so, B, everything looked fine (A, C), but if I then dragged the second word again, C,
 * the word was still B. I needed the index to get the correct word. It worked fine when I was just
 * clicking on the word, but broke when I added drag and drop. Weird. Something I
 * don't understand about the way Compose updates, I'm sure. But passing the index works.
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BlackmailWord(
    index: Int,
    word: String,
    onClick: (Int) -> Unit,
    transferAction: String,
    draggable: Boolean,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = if (draggable) {
            modifier.then(
                Modifier
                    .dragAndDropSource {
                        detectTapGestures(
                            onLongPress = {
                                startTransfer(
                                    DragAndDropTransferData(
                                        clipData = ClipData.newPlainText(transferAction, index.toString()),
                                    )
                                )
                            }
                        )
                    },
            )
        } else {
            modifier.then(
                Modifier
                    .clickable { onClick(index) }
            )
        },
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
        index = 0,
        word = "blackmail",
        onClick = { },
        draggable = false,
        transferAction = transferToLetterAction,
    )
}
