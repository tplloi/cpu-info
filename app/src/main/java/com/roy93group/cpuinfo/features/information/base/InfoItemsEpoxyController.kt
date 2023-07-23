package com.roy93group.cpuinfo.features.information.base

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import com.roy93group.cpuinfo.features.information.base.model.InfoItemViewState

@Suppress("unused")
class InfoItemsEpoxyController(
    private val context: Context
) : TypedEpoxyController<InfoItemViewState>() {

    override fun buildModels(data: InfoItemViewState) {

    }
}
