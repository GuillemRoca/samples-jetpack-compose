package dev.guillem.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.guillem.settings.model.MarketingOption
import dev.guillem.settings.ui.theme.SamplesJetpackComposeTheme

@Composable
fun MarketingSettingItem(
    modifier: Modifier = Modifier,
    selectedOption: MarketingOption,
    onOptionSelected: (option: MarketingOption) -> Unit
) {
    SettingItem(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            val options = stringArrayResource(id = R.array.settings_option_marketing_choice)
            Text(text = stringResource(R.string.setting_marketing_options))
            Spacer(modifier = Modifier.height(8.dp))
            options.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = selectedOption.id == index,
                            onClick = {
                                onOptionSelected(
                                    if (index == MarketingOption.ALLOWED.id) {
                                        MarketingOption.ALLOWED
                                    } else {
                                        MarketingOption.NOT_ALLOWED
                                    }
                                )
                            },
                            role = Role.RadioButton
                        )
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption.id == index,
                        onClick = null
                    )
                    Text(text = option, modifier = Modifier.padding(start = 8.dp))
                }
            }

        }
    }
}

@Preview
@Composable
fun MarketingSettingItemPreview() {
    SamplesJetpackComposeTheme {
        MarketingSettingItem(
            modifier = Modifier.fillMaxWidth(),
            selectedOption = MarketingOption.ALLOWED,
            onOptionSelected = {})
    }
}