package com.galaxyjoy.cpuinfo.domain.observable

import com.galaxyjoy.cpuinfo.data.provider.DataProviderRam
import com.galaxyjoy.cpuinfo.domain.ImmutableInteractor
import com.galaxyjoy.cpuinfo.domain.model.RamData
import com.galaxyjoy.cpuinfo.util.DispatchersProvider
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
