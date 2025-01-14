package dev.guillem.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.guillem.settings.ui.theme.SamplesJetpackComposeTheme

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()
    SamplesJetpackComposeTheme {
        val state = viewModel.uiState.collectAsState().value
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SettingsList(
                modifier = Modifier.padding(innerPadding),
                state = state
            )
        }
    }
}