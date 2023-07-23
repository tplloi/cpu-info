package com.roy93group.cpuinfo.features.information.cpu

import androidx.annotation.Keep
import com.roy93group.cpuinfo.domain.model.CpuData

@Keep
data class CpuInfoViewState(
    val cpuData: CpuData
)
