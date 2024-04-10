package com.wreckingballsoftware.blackmailed.ui.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wreckingballsoftware.blackmailed.R
import com.wreckingballsoftware.blackmailed.ui.navigation.NavGraph
import com.wreckingballsoftware.blackmailed.ui.theme.blackmailedTypography
import com.wreckingballsoftware.blackmailed.ui.theme.dimensions
import com.wreckingballsoftware.blackmailed.ui.welcome.models.WelcomeEvents
import com.wreckingballsoftware.blackmailed.ui.welcome.models.WelcomeNavigation
import org.koin.androidx.compose.getViewModel

@Composable
fun WelcomeScreen(
    navGraph: NavGraph,
    viewModel: WelcomeViewModel = getViewModel()
) {
    val navigation = viewModel.navigation.collectAsStateWithLifecycle(null)
    navigation.value?.let { nav ->
        when (nav) {
            WelcomeNavigation.Play ->navGraph.navigateToGamePlayScreen()
        }
    }

    WelcomeScreenContent(
        onEvent = viewModel::onEvent,
    )
}

@Composable
fun WelcomeScreenContent(
    onEvent: (WelcomeEvents) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            style = MaterialTheme.blackmailedTypography.headline,
        )
        Text(
            text = stringResource(id = R.string.app_name) + "!",
            style = MaterialTheme.blackmailedTypography.headlineLarge)
        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.spaceLarge))
        Text(
            text = stringResource(id = R.string.press_play),
            style = MaterialTheme.blackmailedTypography.title,
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimensions.spaceMedium))
        Button(onClick = { onEvent(WelcomeEvents.OnPlayPressed) }) {
            Text(text = stringResource(id = R.string.play))
        }
    }
}

@Preview(name = "WelcomeScreenContent Preview", showBackground = true)
@Composable
fun WelcomeScreenContentPreview() {
    WelcomeScreenContent(
        onEvent = { },
    )
}