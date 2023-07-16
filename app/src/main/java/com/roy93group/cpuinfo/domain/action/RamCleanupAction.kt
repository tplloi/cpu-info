package com.roy93group.cpuinfo.domain.action

import com.roy93group.cpuinfo.domain.ResultInteractor
import com.roy93group.cpuinfo.utils.DispatchersProvider
import javax.inject.Inject

class RamCleanupAction @Inject constructor(
    dispatchersProvider: DispatchersProvider
) : ResultInteractor<Unit, Unit>() {

    override val dispatcher = dispatchersProvider.io

    override suspend fun doWork(params: Unit) {
        System.runFinalization()
        Runtime.getRuntime().gc()
        System.gc()
    }
}