package com.galaxyjoy.cpuinfo.features.information.cpu

import androidx.annotation.Keep
import com.galaxyjoy.cpuinfo.domain.model.CpuData

@Keep
data class CpuInfoViewState(
    val cpuData: CpuData
)
