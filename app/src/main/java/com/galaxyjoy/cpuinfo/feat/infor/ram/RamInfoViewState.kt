package com.galaxyjoy.cpuinfo.feat.infor.ram

import androidx.annotation.Keep
import com.galaxyjoy.cpuinfo.domain.model.RamData

@Keep
data class RamInfoViewState(
    val ramData: RamData
)
