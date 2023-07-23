package com.roy93group.cpuinfo.features.information.cpu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.roy93group.cpuinfo.domain.observable.CpuDataObservable
import com.roy93group.cpuinfo.domain.observe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * ViewModel for CPU information
 *
 * @author roy93group
 */
@HiltViewModel
class ViewModelCpuInfo @Inject constructor(
    cpuDataObservable: CpuDataObservable
) : ViewModel() {

    val viewState = cpuDataObservable.observe()
        .distinctUntilChanged()
        .map { CpuInfoViewState(it) }
        .asLiveData(viewModelScope.coroutineContext)
}
