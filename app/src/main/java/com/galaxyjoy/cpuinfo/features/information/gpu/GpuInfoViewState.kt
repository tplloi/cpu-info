package com.galaxyjoy.cpuinfo.features.information.gpu

import androidx.annotation.Keep
import com.galaxyjoy.cpuinfo.domain.model.GpuData

@Keep
data class GpuInfoViewState(
    val gpuData: GpuData
)
