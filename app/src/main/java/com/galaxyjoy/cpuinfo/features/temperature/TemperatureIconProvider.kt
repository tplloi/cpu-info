package com.galaxyjoy.cpuinfo.features.temperature

import com.galaxyjoy.cpuinfo.R
import javax.inject.Inject

/**
 * Provides Android ids for temperature icons
 *
 */
class TemperatureIconProvider @Inject constructor() {

    enum class Type {
        CPU, BATTERY
    }

    /**
     * Get icon id for specific type
     */
    fun getIcon(type: Type): Int =
        when (type) {
            Type.CPU -> R.drawable.ic_cpu_temp
            Type.BATTERY -> R.drawable.ic_battery
        }
}
