package com.galaxyjoy.cpuinfo.feat.setting

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.ext.openBrowserPolicy
import com.galaxyjoy.cpuinfo.util.ThemeHelper
import com.galaxyjoy.cpuinfo.util.runOnApiAbove
import moreApp
import rateApp
import shareApp

class FrmSettings : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    companion object {
        const val KEY_TEMPERATURE_UNIT = "temperature_unit"
        const val KEY_RAM_REFRESHING = "ram_refreshing"
        const val KEY_THEME_CONFIG = "key_theme"

        private const val KEY_RAM_CATEGORIES = "pref_key_ram_settings"
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref)

        // RAM widget isn't supported currently on O and above
        runOnApiAbove(Build.VERSION_CODES.N_MR1) {
            preferenceScreen.removePreference(preferenceScreen.findPreference(KEY_RAM_CATEGORIES)!!)
        }

        val rateAppPreference: Preference? = findPreference("key_rate_app")
        rateAppPreference?.setOnPreferenceClickListener {
            activity?.let {
                it.rateApp(it.packageName)
            }
            true
        }
        val moreAppPreference: Preference? = findPreference("key_more_app")
        moreAppPreference?.setOnPreferenceClickListener {
            activity?.moreApp()
            true
        }
        val shareAppPreference: Preference? = findPreference("key_share_app")
        shareAppPreference?.setOnPreferenceClickListener {
            activity?.shareApp()
            true
        }
        val policyAppPreference: Preference? = findPreference("key_policy_app")
        policyAppPreference?.setOnPreferenceClickListener {
            activity?.openBrowserPolicy()
            true
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

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
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
