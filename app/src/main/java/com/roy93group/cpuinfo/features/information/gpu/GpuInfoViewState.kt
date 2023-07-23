package com.roy93group.cpuinfo.features.information.gpu

import androidx.annotation.Keep
import com.roy93group.cpuinfo.domain.model.GpuData

@Keep
data class GpuInfoViewState(
    val gpuData: GpuData
)
