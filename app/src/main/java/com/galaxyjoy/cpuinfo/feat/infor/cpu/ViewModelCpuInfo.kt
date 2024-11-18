package com.galaxyjoy.cpuinfo.feat.infor.cpu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.galaxyjoy.cpuinfo.domain.observable.ObservableCpuData
import com.galaxyjoy.cpuinfo.domain.observe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * ViewModel for CPU information
 *
 * @author galaxyjoy
 */
@HiltViewModel
class ViewModelCpuInfo @Inject constructor(
    observableCpuData: ObservableCpuData
) : ViewModel() {

    val viewState = observableCpuData.observe()
        .distinctUntilChanged()
        .map { CpuInfoViewState(it) }
        .asLiveData(viewModelScope.coroutineContext)
}
