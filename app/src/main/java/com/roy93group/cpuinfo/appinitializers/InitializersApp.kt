package com.roy93group.cpuinfo.appinitializers

import android.app.Application
import javax.inject.Inject

class InitializersApp @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}
