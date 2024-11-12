package com.galaxyjoy.cpuinfo.appinitializers

import android.app.Application

interface AppInitializer {
    fun init(application: Application)
}
