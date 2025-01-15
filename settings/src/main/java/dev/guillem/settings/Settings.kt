package dev.guillem.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.guillem.settings.ui.theme.SamplesJetpackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()
    SamplesJetpackComposeTheme {
        val state = viewModel.uiState.collectAsState().value
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = { /* TODO */ }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = stringResource(R.string.cd_label_go_back)
                            )
                        }
                    },
                    title = { Text(stringResource(R.string.title_settings)) }
                )
            },
        ) { innerPadding ->
            SettingsList(
                modifier = Modifier.padding(innerPadding),
                state = state,
                toggleNotificationSetting = viewModel::toggleNotificationSetting
            )
        }
    }
}

@Preview
@Composable
fun SettingsPreview() {
    Settings()
}