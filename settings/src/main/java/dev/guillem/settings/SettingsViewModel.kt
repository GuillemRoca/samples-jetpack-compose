package dev.guillem.settings

import androidx.lifecycle.ViewModel
import dev.guillem.settings.model.MarketingOption
import dev.guillem.settings.model.SettingsState
import dev.guillem.settings.model.Theme
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel : ViewModel() {

    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationSetting() {
        uiState.value = uiState.value.copy(
            notificationsEnabled = !uiState.value.notificationsEnabled
        )
    }

    fun toggleHintsSetting() {
        uiState.value = uiState.value.copy(
            hintsEnabled = !uiState.value.hintsEnabled
        )
    }

    fun setMarketingSetting(option: MarketingOption) {
        uiState.value = uiState.value.copy(
            marketingOption = option
        )
    }

    fun setTheme(theme: Theme) {
        uiState.value = uiState.value.copy(
            themeOption = theme
        )
    }
}