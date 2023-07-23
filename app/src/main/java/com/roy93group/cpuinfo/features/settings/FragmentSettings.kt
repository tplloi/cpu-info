package com.roy93group.cpuinfo.features.settings

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.roy93group.cpuinfo.R
import com.roy93group.cpuinfo.utils.ThemeHelper
import com.roy93group.cpuinfo.utils.runOnApiAbove

class FragmentSettings : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    companion object {
        const val KEY_TEMPERATURE_UNIT = "temperature_unit"
        const val KEY_RAM_REFRESHING = "ram_refreshing"
        const val KEY_THEME_CONFIG = "key_theme"

        private const val KEY_RAM_CATEGORIES = "pref_key_ram_settings"
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)

        // RAM widget isn't supported currently on O and above
        runOnApiAbove(Build.VERSION_CODES.N_MR1) {
            preferenceScreen.removePreference(preferenceScreen.findPreference(KEY_RAM_CATEGORIES)!!)
        }
    }

    override fun onResume() {
        super.onResume()

        preferenceScreen.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()

        preferenceScreen.sharedPreferences?.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        when (key) {
            KEY_THEME_CONFIG -> {
                ThemeHelper.applyTheme(
                    sharedPreferences.getString(
                        ThemeHelper.KEY_THEME,
                        ThemeHelper.DEFAULT_MODE
                    )!!
                )
            }
        }
    }
}
