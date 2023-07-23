package com.roy93group.cpuinfo.features.information.ram

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.roy93group.cpuinfo.domain.action.RamCleanupAction
import com.roy93group.cpuinfo.domain.observable.RamDataObservable
import com.roy93group.cpuinfo.domain.observe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for RAM info
 *
 * @author roy93group
 */
@HiltViewModel
class ViewModelRamInfo @Inject constructor(
    ramDataObservable: RamDataObservable,
    private val ramCleanupAction: RamCleanupAction
) : ViewModel() {
    val viewState = ramDataObservable.observe()
        .distinctUntilChanged()
        .map { RamInfoViewState(it) }
        .asLiveData(viewModelScope.coroutineContext)

    fun onClearRamClicked() {
        viewModelScope.launch { ramCleanupAction(Unit) }
    }
}
