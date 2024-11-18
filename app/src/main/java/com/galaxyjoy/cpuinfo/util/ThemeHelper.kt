package com.galaxyjoy.cpuinfo.util

import androidx.appcompat.app.AppCompatDelegate

/**
 * Helper class to set app theme
 **/
object ThemeHelper {

    const val KEY_THEME = "key_theme"

    private const val LIGHT_MODE = "light"
    private const val DARK_MODE = "dark"
    const val DEFAULT_MODE = "default"

    fun applyTheme(themePref: String) {
        when (themePref) {
            LIGHT_MODE -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            DARK_MODE -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

            else -> {
                runOnApiAbove(28, {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                }, {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
                })
            }
        }
    }
}
