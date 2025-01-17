package dev.guillem.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.guillem.settings.model.Theme

@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onOptionSelected: (theme: Theme) -> Unit
) {
    SettingItem(modifier = modifier) {
        var expanded by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .clickable(onClickLabel = stringResource(id = R.string.cd_select_theme)) {
                    expanded = !expanded
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.setting_option_theme)
            )
            Text(text = stringResource(id = selectedTheme.label))
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                Theme.entries.forEach {
                    DropdownMenuItem(
                        onClick = {
                            onOptionSelected(it)
                            expanded = false
                        },
                        text = {
                            Text(text = stringResource(id = it.label))
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ThemeSettingItemPreview() {
    ThemeSettingItem(
        modifier = Modifier.fillMaxWidth(),
        selectedTheme = Theme.SYSTEM,
        onOptionSelected = {})
}