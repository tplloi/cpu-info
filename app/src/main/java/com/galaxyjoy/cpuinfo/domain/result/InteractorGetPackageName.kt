package com.galaxyjoy.cpuinfo.domain.result

import android.content.Context
import com.galaxyjoy.cpuinfo.domain.ResultInteractor
import com.galaxyjoy.cpuinfo.utils.DispatchersProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class InteractorGetPackageName @Inject constructor(
    dispatchersProvider: DispatchersProvider,
    @ApplicationContext private val context: Context
) : ResultInteractor<Unit, String>() {

    override val dispatcher = dispatchersProvider.io

    override suspend fun doWork(params: Unit): String {
        return context.packageName
    }
}
