package dev.guillem.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class AppVersionSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun App_Version_Displayed() {
        val appVersion = "1.0.0"
        composeTestRule.setContent {
            AppVersionSettingItem(appVersion = appVersion)
        }

        composeTestRule.onNodeWithText(appVersion)
            .assertIsDisplayed()
    }
}