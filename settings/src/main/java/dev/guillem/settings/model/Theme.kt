package dev.guillem.settings.model

import androidx.annotation.StringRes
import dev.guillem.settings.R

enum class Theme(@StringRes label: Int) {
    LIGHT(label = R.string.theme_light),
    DARK(label = R.string.theme_dark),
    SYSTEM(label = R.string.theme_system)
}