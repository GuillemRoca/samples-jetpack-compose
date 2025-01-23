package dev.guillem.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ManageSubscriptionSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Displayed() {
        val title = "Manage Subscription"
        composeTestRule.setContent {
            ManageSubscriptionSettingItem(title = title) { }
        }

        composeTestRule.onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun On_Setting_Click_Triggered() {
        val title = "Manage Subscription"
        val callback = mock<() -> Unit>()
        composeTestRule.setContent {
            ManageSubscriptionSettingItem(
                title = title,
                onSettingClick = callback
            )
        }

        composeTestRule.onNodeWithText(title)
            .performClick()

        verify(callback).invoke()
    }
}