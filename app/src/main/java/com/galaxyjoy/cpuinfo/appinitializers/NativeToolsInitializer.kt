package com.galaxyjoy.cpuinfo.appinitializers

import android.app.Application
import com.getkeepsafe.relinker.ReLinker
import com.galaxyjoy.cpuinfo.data.provider.DataNativeProviderCpu
import javax.inject.Inject

class NativeToolsInitializer @Inject constructor(
    private val dataNativeProviderCpu: DataNativeProviderCpu
) : AppInitializer {

    override fun init(application: Application) {
        ReLinker.loadLibrary(application, "cpuinfo-libs")
        dataNativeProviderCpu.initLibrary()
    }
}
