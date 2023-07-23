package com.roy93group.cpuinfo.features.information.ram

import androidx.annotation.Keep
import com.roy93group.cpuinfo.domain.model.RamData

@Keep
data class RamInfoViewState(
    val ramData: RamData
)
