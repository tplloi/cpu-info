package com.roy93group.cpuinfo.domain.observable

import com.roy93group.cpuinfo.data.provider.GpuDataProvider
import com.roy93group.cpuinfo.domain.MutableInteractor
import com.roy93group.cpuinfo.domain.model.GpuData
import com.roy93group.cpuinfo.utils.DispatchersProvider
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GpuDataObservable @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    private val gpuDataProvider: GpuDataProvider
) : MutableInteractor<GpuDataObservable.Params, GpuData>() {

    override val dispatcher = dispatchersProvider.io

    override fun createObservable(params: Params) = flow {
        emit(
            GpuData(
                gpuDataProvider.getVulkanVersion(),
                gpuDataProvider.getGlEsVersion(),
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