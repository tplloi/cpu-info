package com.galaxyjoy.cpuinfo.feat.infor.gpu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.galaxyjoy.cpuinfo.domain.observable.ObservableGpuData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * ViewModel for GPU information. It is using custom SurfaceView to get more GPU details from OpenGL
 *
 */
@HiltViewModel
class VMGpuInfo @Inject constructor(
    private val observableGpuData: ObservableGpuData
) : ViewModel() {

    val viewState = observableGpuData.observe()
        .distinctUntilChanged()
        .map { GpuInfoViewState(it) }
        .asLiveData(viewModelScope.coroutineContext)

    init {
        observableGpuData(ObservableGpuData.Params())
    }

    fun onGlInfoReceived(glVendor: String?, glRenderer: String?, glExtensions: String?) {
        observableGpuData(ObservableGpuData.Params(glVendor, glRenderer, glExtensions))
    }
}
