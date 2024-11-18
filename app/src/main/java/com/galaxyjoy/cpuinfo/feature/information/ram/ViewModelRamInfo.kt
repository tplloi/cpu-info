package com.galaxyjoy.cpuinfo.feature.information.ram

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.galaxyjoy.cpuinfo.domain.action.RamCleanupAction
import com.galaxyjoy.cpuinfo.domain.observable.ObservableRamData
import com.galaxyjoy.cpuinfo.domain.observe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for RAM info
 *
 * @author galaxyjoy
 */
@HiltViewModel
class ViewModelRamInfo @Inject constructor(
    observableRamData: ObservableRamData,
    private val ramCleanupAction: RamCleanupAction
) : ViewModel() {
    val viewState = observableRamData.observe()
        .distinctUntilChanged()
        .map { RamInfoViewState(it) }
        .asLiveData(viewModelScope.coroutineContext)

    fun onClearRamClicked() {
        viewModelScope.launch { ramCleanupAction(Unit) }
    }
}
