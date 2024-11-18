package com.galaxyjoy.cpuinfo.feat.infor.base.model

import androidx.annotation.Keep

@Keep
data class InfoItemViewState(
    val items: List<Pair<String, String>>
)
