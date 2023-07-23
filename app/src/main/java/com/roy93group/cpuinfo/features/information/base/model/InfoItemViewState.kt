package com.roy93group.cpuinfo.features.information.base.model

import androidx.annotation.Keep

@Keep
data class InfoItemViewState(
    val items: List<Pair<String, String>>
)
