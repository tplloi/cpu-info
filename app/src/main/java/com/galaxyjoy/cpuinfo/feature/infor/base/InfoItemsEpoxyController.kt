package com.galaxyjoy.cpuinfo.feature.infor.base

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import com.galaxyjoy.cpuinfo.feature.infor.base.model.InfoItemViewState

@Suppress("unused")
class InfoItemsEpoxyController(
    private val context: Context
) : TypedEpoxyController<InfoItemViewState>() {

    override fun buildModels(data: InfoItemViewState) {

    }
}
