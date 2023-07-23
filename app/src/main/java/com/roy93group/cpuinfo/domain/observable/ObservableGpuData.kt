package com.roy93group.cpuinfo.domain.observable

import com.roy93group.cpuinfo.data.provider.DataProviderGpu
import com.roy93group.cpuinfo.domain.MutableInteractor
import com.roy93group.cpuinfo.domain.model.GpuData
import com.roy93group.cpuinfo.utils.DispatchersProvider
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ObservableGpuData @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    private val dataProviderGpu: DataProviderGpu
) : MutableInteractor<ObservableGpuData.Params, GpuData>() {

    override val dispatcher = dispatchersProvider.io

    override fun createObservable(params: Params) = flow {
        emit(
            GpuData(
                dataProviderGpu.getVulkanVersion(),
                dataProviderGpu.getGlEsVersion(),
                params.glVendor,
                params.glRenderer,
                params.glExtensions
            )
        )
    }

    data class Params(
        val glVendor: String? = null,
        val glRenderer: String? = null,
        val glExtensions: String? = null
    )
}
