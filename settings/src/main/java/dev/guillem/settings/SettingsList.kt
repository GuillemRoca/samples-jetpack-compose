package dev.guillem.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.guillem.settings.model.SettingsState

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState,
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
    }
}