package com.galaxyjoy.cpuinfo.domain.action

import com.galaxyjoy.cpuinfo.domain.ResultInteractor
import com.galaxyjoy.cpuinfo.util.DispatchersProvider
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
