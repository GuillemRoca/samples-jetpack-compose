package dev.guillem.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.guillem.settings.model.SettingsState
import dev.guillem.settings.ui.theme.SamplesJetpackComposeTheme

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState,
    toggleNotificationSetting: () -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        NotificationSettings(
            title = stringResource(R.string.setting_enabled_notifications),
            checked = state.notificationsEnabled,
            onCheckedChanged = toggleNotificationSetting
        )
    }
}

@Preview
@Composable
fun SettingsListPreview() {
    SamplesJetpackComposeTheme {
        SettingsList(
            state = SettingsState(),
            toggleNotificationSetting = {}
        )
    }
}