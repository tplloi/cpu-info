package com.galaxyjoy.cpuinfo.appinitializers

import android.app.Application
import com.galaxyjoy.cpuinfo.BuildConfig
import timber.log.Timber
import javax.inject.Inject

class InitializerTimber @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
