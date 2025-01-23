package dev.guillem.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import dev.guillem.settings.Tags.TAG_SELECT_THEME
import dev.guillem.settings.Tags.TAG_THEME
import dev.guillem.settings.Tags.TAG_THEME_OPTION
import dev.guillem.settings.model.Theme
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ThemeSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Selected_Theme_Displayed() {
        val theme = Theme.DARK

        composeTestRule.setContent {
            ThemeSettingItem(selectedTheme = theme, onOptionSelected = {})
        }

        composeTestRule.onNodeWithTag(TAG_THEME, useUnmergedTree = true)
            .assertTextEquals(
                InstrumentationRegistry.getInstrumentation().targetContext.getString(theme.label)
            )
    }

    @Test
    fun Theme_Options_Displayed() {
        composeTestRule.setContent {
            ThemeSettingItem(selectedTheme = Theme.DARK, onOptionSelected = {})
        }

        composeTestRule.onNodeWithTag(TAG_SELECT_THEME)
            .performClick()

        Theme.entries.forEach { theme ->
            composeTestRule.onNodeWithTag(
                TAG_THEME_OPTION + InstrumentationRegistry.getInstrumentation().targetContext
                    .getString(theme.label)
            ).assertIsDisplayed()
        }
    }

    @Test
    fun Theme_Callback_Triggered() {
        val theme = Theme.LIGHT
        val callback = mock<(theme: Theme) -> Unit>()
        composeTestRule.setContent {
            ThemeSettingItem(
                selectedTheme = Theme.DARK,
                onOptionSelected = callback
            )
        }

        composeTestRule.onNodeWithTag(TAG_SELECT_THEME)
            .performClick()

        composeTestRule.onNodeWithTag(
            TAG_THEME_OPTION + InstrumentationRegistry.getInstrumentation().targetContext
                .getString(theme.label)
        ).performClick()

        verify(callback).invoke(theme)
    }
}