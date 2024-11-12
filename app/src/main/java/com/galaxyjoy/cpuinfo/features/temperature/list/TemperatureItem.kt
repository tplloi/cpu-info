package com.galaxyjoy.cpuinfo.features.temperature.list

/**
 * Model for temperature items
 */
data class TemperatureItem(
    val iconRes: Int,
    val name: String,
    var temperature: Float
)
