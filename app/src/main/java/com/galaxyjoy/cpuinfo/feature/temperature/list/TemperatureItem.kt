package com.galaxyjoy.cpuinfo.feature.temperature.list

import androidx.annotation.Keep

/**
 * Model for temperature items
 */
@Keep
data class TemperatureItem(
    val iconRes: Int,
    val name: String,
    var temperature: Float
)
