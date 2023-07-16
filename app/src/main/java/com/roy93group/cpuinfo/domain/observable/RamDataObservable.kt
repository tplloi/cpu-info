package com.roy93group.cpuinfo.domain.observable

import com.roy93group.cpuinfo.data.provider.RamDataProvider
import com.roy93group.cpuinfo.domain.ImmutableInteractor
import com.roy93group.cpuinfo.domain.model.RamData
import com.roy93group.cpuinfo.utils.DispatchersProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RamDataObservable @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    private val ramDataProvider: RamDataProvider
) : ImmutableInteractor<Unit, RamData>() {

    override val dispatcher = dispatchersProvider.io

    override fun createObservable(params: Unit) = flow {
        while (true) {
            val total = ramDataProvider.getTotalBytes()
            val available = ramDataProvider.getAvailableBytes()
            val availablePercentage = ramDataProvider.getAvailablePercentage()
            val threshold = ramDataProvider.getThreshold()
            emit(RamData(total, available, availablePercentage, threshold))
            delay(REFRESH_DELAY)
        }
    }

    companion object {
        private const val REFRESH_DELAY = 5000L
    }
}