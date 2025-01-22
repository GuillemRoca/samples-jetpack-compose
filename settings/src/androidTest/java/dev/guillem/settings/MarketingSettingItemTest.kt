package dev.guillem.settings

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import dev.guillem.settings.Tags.TAG_MARKETING_OPTION
import dev.guillem.settings.model.MarketingOption
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class MarketingSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Marketing_Option_Selected() {
        val option = MarketingOption.NOT_ALLOWED

        composeTestRule.setContent {
            MarketingSettingItem(selectedOption = option, onOptionSelected = {})
        }

        composeTestRule.onNodeWithTag(TAG_MARKETING_OPTION + option.id)
            .assertIsSelected()
    }

    @Test
    fun On_Option_Selected_Triggered() {
        val option = MarketingOption.ALLOWED
        val callback = mock<(option: MarketingOption) -> Unit>()

        composeTestRule.setContent {
            MarketingSettingItem(
                selectedOption = MarketingOption.NOT_ALLOWED,
                onOptionSelected = callback
            )
        }

        composeTestRule.onNodeWithTag(TAG_MARKETING_OPTION + option.id)
            .performClick()

        verify(callback).invoke(option)
    }
}