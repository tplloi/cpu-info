package com.galaxyjoy.cpuinfo.feature.information.ram

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.itemValue
import com.galaxyjoy.cpuinfo.util.Utils
import com.galaxyjoy.cpuinfo.verticalDivider

class RamInfoEpoxyController(
    private val context: Context
) : TypedEpoxyController<RamInfoViewState>() {

    override fun buildModels(data: RamInfoViewState) {
        itemValue {
            id("total")
            title(this@RamInfoEpoxyController.context.getString(R.string.total_memory))
            value(Utils.convertBytesToMega(data.ramData.total))
        }
        verticalDivider { id("available_divider") }
        itemValue {
            id("available")
            title(this@RamInfoEpoxyController.context.getString(R.string.available_memory))
            value(
                "${Utils.convertBytesToMega(data.ramData.available)} (${data.ramData.availablePercentage}%)"
            )
        }
        verticalDivider { id("threshold_divider") }
        itemValue {
            id("threshold")
            title(this@RamInfoEpoxyController.context.getString(R.string.threshold))
            value(Utils.convertBytesToMega(data.ramData.threshold))
        }
    }
}
