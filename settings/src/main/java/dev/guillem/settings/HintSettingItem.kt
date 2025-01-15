package dev.guillem.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
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

@Composable
fun HintSettingItem(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onCheckedChange: () -> Unit,
) {
    SettingItem(modifier = modifier) {
        val stateDescription = if (checked) {
            stringResource(R.string.cd_hints_enabled)
        } else {
            stringResource(R.string.cd_hints_disabled)
        }
        Row(
            modifier = Modifier
                .toggleable(
                    value = checked,
                    onValueChange = { onCheckedChange() },
                    role = Role.Checkbox
                )
                .padding(16.dp)
                .semantics {
                    this.stateDescription = stateDescription
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, modifier = Modifier.weight(1f))
            Checkbox(checked = checked, onCheckedChange = null)
        }
    }
}

@Preview
@Composable
fun HintSettingItemPreview() {
    HintSettingItem(title = "Enable Hints", checked = true, onCheckedChange = {})
}