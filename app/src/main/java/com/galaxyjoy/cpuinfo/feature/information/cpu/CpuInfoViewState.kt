package com.galaxyjoy.cpuinfo.feature.information.cpu

import androidx.annotation.Keep
import com.galaxyjoy.cpuinfo.domain.model.CpuData

@Keep
data class CpuInfoViewState(
    val cpuData: CpuData
)
