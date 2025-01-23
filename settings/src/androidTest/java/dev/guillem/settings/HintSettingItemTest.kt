package dev.guillem.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dev.guillem.settings.Tags.TAG_CHECK_ITEM
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class HintSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Displayed() {
        val title = "Enable Hints"
        composeTestRule.setContent {
            HintSettingItem(title = title, checked = false) { }
        }

        composeTestRule.onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun Setting_Checked() {
        composeTestRule.setContent {
            HintSettingItem(title = "Enable Hints", checked = true) { }
        }

        composeTestRule.onNodeWithTag(TAG_CHECK_ITEM)
            .assertIsOn()
    }

    @Test
    fun Callback_Triggered() {
        val callback = mock<() -> Unit>()
        composeTestRule.setContent {
            HintSettingItem(
                title = "Enable Hints",
                checked = false,
                onCheckedChange = callback
            )
        }

        composeTestRule.onNodeWithTag(TAG_CHECK_ITEM)
            .performClick()

        verify(callback).invoke()
    }
}