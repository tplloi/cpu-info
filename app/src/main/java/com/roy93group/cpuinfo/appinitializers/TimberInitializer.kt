package com.roy93group.cpuinfo.appinitializers

import android.app.Application
import com.roy93group.cpuinfo.BuildConfig
import timber.log.Timber
import javax.inject.Inject

class TimberInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}