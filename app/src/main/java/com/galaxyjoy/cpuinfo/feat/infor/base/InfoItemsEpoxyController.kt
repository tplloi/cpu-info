package com.galaxyjoy.cpuinfo.feat.infor.base

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import com.galaxyjoy.cpuinfo.feat.infor.base.model.InfoItemViewState

@Suppress("unused")
class InfoItemsEpoxyController(
    private val context: Context
) : TypedEpoxyController<InfoItemViewState>() {

    override fun buildModels(data: InfoItemViewState) {

    }
}
