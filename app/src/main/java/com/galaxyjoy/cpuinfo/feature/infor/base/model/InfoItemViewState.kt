package com.galaxyjoy.cpuinfo.feature.infor.base.model

import androidx.annotation.Keep

@Keep
data class InfoItemViewState(
    val items: List<Pair<String, String>>
)
