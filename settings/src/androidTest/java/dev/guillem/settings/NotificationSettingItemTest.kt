package dev.guillem.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dev.guillem.settings.Tags.TAG_TOGGLE_ITEM
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class NotificationSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Displayed() {
        val title = "Enable Notifications"
        composeTestRule.setContent {
            NotificationSetting(title = title, checked = false) { }
        }

        composeTestRule.onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun Setting_Checked() {
        composeTestRule.setContent {
            NotificationSetting(title = "Enable Notifications", checked = true) { }
        }

        composeTestRule.onNodeWithTag(TAG_TOGGLE_ITEM)
            .assertIsOn()
    }

    @Test
    fun Toggle_Callback_Triggered() {
        val callback = mock<() -> Unit>()
        composeTestRule.setContent {
            NotificationSetting(
                title = "Enable Notifications",
                checked = true,
                onCheckedChanged = callback
            )
        }

        composeTestRule.onNodeWithTag(TAG_TOGGLE_ITEM)
            .performClick()

        verify(callback).invoke()
    }
}