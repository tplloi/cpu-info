package com.galaxyjoy.cpuinfo.feature.infor.cpu

import androidx.annotation.Keep
import com.galaxyjoy.cpuinfo.domain.model.CpuData

@Keep
data class CpuInfoViewState(
    val cpuData: CpuData
)
