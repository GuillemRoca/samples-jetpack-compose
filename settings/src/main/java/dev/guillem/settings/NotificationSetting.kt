package dev.guillem.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.guillem.settings.ui.theme.SamplesJetpackComposeTheme

@Composable
fun NotificationSetting(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onCheckedChanged: () -> Unit
) {
    SettingItem(modifier = modifier) {
        val stateDescription = if (checked) {
            stringResource(R.string.cd_notifications_enabled)
        } else {
            stringResource(R.string.cd_notifications_disabled)
        }
        Row(
            modifier = Modifier
                .toggleable(
                    value = checked,
                    onValueChange = { onCheckedChanged() },
                    role = Role.Switch
                )
                .padding(16.dp)
                .semantics {
                    this.stateDescription = stateDescription
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, modifier = Modifier.weight(1f))
            Switch(
                checked = checked,
                onCheckedChange = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationSettingsPreview() {
    SamplesJetpackComposeTheme {
        NotificationSetting(
            modifier = Modifier.fillMaxWidth(),
            title = "Enable notifications",
            checked = true,
            onCheckedChanged = { }
        )
    }
}
