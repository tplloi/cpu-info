package com.galaxyjoy.cpuinfo.appinitializers

import android.app.Application
import android.content.SharedPreferences
import com.galaxyjoy.cpuinfo.utils.ThemeHelper
import javax.inject.Inject

/**
 * Apply theme on app start
 *
 */
class InitializerTheme @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : AppInitializer {

    override fun init(application: Application) {
        sharedPreferences.getString(ThemeHelper.KEY_THEME, ThemeHelper.DEFAULT_MODE)?.let {
            ThemeHelper.applyTheme(it)
        }
    }
}
