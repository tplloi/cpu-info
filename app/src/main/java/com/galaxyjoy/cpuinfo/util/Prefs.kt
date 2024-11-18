package com.galaxyjoy.cpuinfo.util

import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Simple wrapper for [SharedPreferences] which can also serialize and deserialize object from JSON
 */
@Singleton
class Prefs @Inject constructor(private val sharedPreferences: SharedPreferences) {

    /**
     * Verify if passed [key] is already saved in [SharedPreferences]
     */
    fun contains(key: String): Boolean =
        sharedPreferences.contains(key)

    /**
     * Insert passed [value] with specific [key] into [SharedPreferences]. If [value] isn't a known
     * type it will be parsed into JSON.
     */
    fun insert(key: String, value: Any) {
        when (value) {
            is Int -> sharedPreferences.edit().putInt(key, value).apply()
            is Float -> sharedPreferences.edit().putFloat(key, value).apply()
            is String -> sharedPreferences.edit().putString(key, value).apply()
            is Boolean -> sharedPreferences.edit().putBoolean(key, value).apply()
            is Long -> sharedPreferences.edit().putLong(key, value).apply()
            else -> {
                val s = Gson().toJson(value)
                sharedPreferences.edit().putString(key, s).apply()
            }
        }
    }

    /**
     * Get value with specific [key] stored in [SharedPreferences] and cast it into [T] type from
     * default value.
     */
    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: String, default: T): T {
        when (default) {
            is Int -> return sharedPreferences.getInt(key, default) as T
            is Float -> return sharedPreferences.getFloat(key, default) as T
            is String -> return sharedPreferences.getString(key, default) as T
            is Boolean -> return sharedPreferences.getBoolean(key, default) as T
            is Long -> return sharedPreferences.getLong(key, default) as T
            else -> {
                val value = sharedPreferences.getString(key, "")
                if (!value.isNullOrEmpty()) {
                    val typedObject = default as Any
                    return Gson().fromJson(value, typedObject.javaClass) as T
                }
                return default
            }
        }
    }

    /**
     * Remove [key] from [SharedPreferences]
     */
    @Suppress("unused")
    fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }
}
