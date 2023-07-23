package com.roy93group.cpuinfo.domain.observable

import com.roy93group.cpuinfo.data.provider.DataProviderRam
import com.roy93group.cpuinfo.domain.ImmutableInteractor
import com.roy93group.cpuinfo.domain.model.RamData
import com.roy93group.cpuinfo.utils.DispatchersProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ObservableRamData @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    private val dataProviderRam: DataProviderRam
) : ImmutableInteractor<Unit, RamData>() {

    override val dispatcher = dispatchersProvider.io

    override fun createObservable(params: Unit) = flow {
        while (true) {
            val total = dataProviderRam.getTotalBytes()
            val available = dataProviderRam.getAvailableBytes()
            val availablePercentage = dataProviderRam.getAvailablePercentage()
            val threshold = dataProviderRam.getThreshold()
            emit(RamData(total, available, availablePercentage, threshold))
            delay(REFRESH_DELAY)
        }
    }

    companion object {
        private const val REFRESH_DELAY = 5000L
    }
}
