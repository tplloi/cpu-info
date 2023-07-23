package com.roy93group.cpuinfo.features.information.gpu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.roy93group.cpuinfo.domain.observable.GpuDataObservable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * ViewModel for GPU information. It is using custom SurfaceView to get more GPU details from OpenGL
 *
 */
@HiltViewModel
class ViewModelGpuInfo @Inject constructor(
    private val observableGpuData: GpuDataObservable
) : ViewModel() {

    val viewState = observableGpuData.observe()
        .distinctUntilChanged()
        .map { GpuInfoViewState(it) }
        .asLiveData(viewModelScope.coroutineContext)

    init {
        observableGpuData(GpuDataObservable.Params())
    }

    fun onGlInfoReceived(glVendor: String?, glRenderer: String?, glExtensions: String?) {
        observableGpuData(GpuDataObservable.Params(glVendor, glRenderer, glExtensions))
    }
}
