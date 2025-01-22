package dev.guillem.settings

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import dev.guillem.settings.Tags.TAG_TOGGLE_ITEM
import org.junit.Rule
import org.junit.Test

class SettingsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Enable_Notifications_Settting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_enabled_notifications)
    }

    @Test
    fun Show_Hints_Settting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_show_hints)
    }

    @Test
    fun Manage_Subscription_Settting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_manage_subscription)
    }

    @Test
    fun Option_Theme_Settting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_option_theme)
    }

    @Test
    fun App_Version_Settting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_app_version)
    }

    private fun assertSettingIsDisplayed(@StringRes title: Int) {
        composeTestRule.setContent {
            Settings()
        }

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation().targetContext.getString(title)
        ).assertIsDisplayed()
    }

    @Test
    fun Enable_Notifications_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.setting_enabled_notifications)
        ).performClick()

        composeTestRule.onNodeWithTag(TAG_TOGGLE_ITEM)
            .assertIsOn()
    }
}