package com.roy93group.cpuinfo.domain.model

import androidx.annotation.Keep

@Keep
data class GpuData(
    val vulkanVersion: String,
    val glesVersio: String,
    val glVendor: String?,
    val glRenderer: String?,
    val glExtensions: String?
)
