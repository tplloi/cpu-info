/*
 * Copyright 2017 KG Soft
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.roy93group.cpuinfo.features.information.ram

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.roy93group.cpuinfo.domain.action.RamCleanupAction
import com.roy93group.cpuinfo.domain.observable.RamDataObservable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.roy93group.cpuinfo.domain.observe

/**
 * ViewModel for RAM info
 *
 * @author roy93group
 */
@HiltViewModel
class RamInfoViewModel @Inject constructor(
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