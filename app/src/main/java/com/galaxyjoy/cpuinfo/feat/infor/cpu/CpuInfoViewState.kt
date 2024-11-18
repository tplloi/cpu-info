package com.galaxyjoy.cpuinfo.feat.infor.cpu

import androidx.annotation.Keep
import com.galaxyjoy.cpuinfo.domain.model.CpuData

@Keep
data class CpuInfoViewState(
    val cpuData: CpuData
)
