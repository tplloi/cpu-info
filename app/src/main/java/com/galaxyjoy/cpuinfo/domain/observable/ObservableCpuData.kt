package com.galaxyjoy.cpuinfo.domain.observable

import com.galaxyjoy.cpuinfo.data.provider.DataNativeProviderCpu
import com.galaxyjoy.cpuinfo.data.provider.DataProviderCpu
import com.galaxyjoy.cpuinfo.domain.ImmutableInteractor
import com.galaxyjoy.cpuinfo.domain.model.CpuData
import com.galaxyjoy.cpuinfo.util.DispatchersProvider
import com.galaxyjoy.cpuinfo.util.Utils
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ObservableCpuData @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    private val dataProviderCpu: DataProviderCpu,
    private val dataNativeProviderCpu: DataNativeProviderCpu
) : ImmutableInteractor<Unit, CpuData>() {

    override val dispatcher = dispatchersProvider.io

    override fun createObservable(params: Unit) = flow {
        while (true) {
            val processorName = dataNativeProviderCpu.getCpuName()
            val abi = dataProviderCpu.getAbi()
            val coreNumber = dataProviderCpu.getNumberOfCores()
            val hasArmNeon = dataNativeProviderCpu.hasArmNeon()
            val frequencies = mutableListOf<CpuData.Frequency>()
            val l1dCaches = dataNativeProviderCpu.getL1dCaches()
                ?.joinToString(separator = "\n") { Utils.humanReadableByteCount(it.toLong()) }
                ?: ""
            val l1iCaches = dataNativeProviderCpu.getL1iCaches()
                ?.joinToString(separator = "\n") { Utils.humanReadableByteCount(it.toLong()) }
                ?: ""
            val l2Caches = dataNativeProviderCpu.getL2Caches()
                ?.joinToString(separator = "\n") { Utils.humanReadableByteCount(it.toLong()) }
                ?: ""
            val l3Caches = dataNativeProviderCpu.getL3Caches()
                ?.joinToString(separator = "\n") { Utils.humanReadableByteCount(it.toLong()) }
                ?: ""
            val l4Caches = dataNativeProviderCpu.getL4Caches()
                ?.joinToString(separator = "\n") { Utils.humanReadableByteCount(it.toLong()) }
                ?: ""
            for (i in 0 until coreNumber) {
                val (min, max) = dataProviderCpu.getMinMaxFreq(i)
                val current = dataProviderCpu.getCurrentFreq(i)
                frequencies.add(CpuData.Frequency(min, max, current))
            }
            emit(
                CpuData(
                    processorName, abi, coreNumber, hasArmNeon, frequencies,
                    l1dCaches, l1iCaches, l2Caches, l3Caches, l4Caches
                )
            )
            delay(REFRESH_DELAY)
        }
    }

    companion object {
        private const val REFRESH_DELAY = 1000L
    }
}
