package com.roy93group.cpuinfo.domain.model

import androidx.annotation.Keep

@Keep
data class RamData(
    val total: Long,
    val available: Long,
    val availablePercentage: Int,
    val threshold: Long
)
