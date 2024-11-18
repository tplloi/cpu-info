package com.galaxyjoy.cpuinfo

import androidx.multidex.MultiDexApplication
import com.galaxyjoy.cpuinfo.appinitializers.InitializersApp
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

//TODO roy93~ ad applovin
//TODO roy93~ firebase
//TODO roy93~ icon launcher
//TODO roy93~rate, more, share, fb fan page, policy
//TODO roy93~keystore

//done mckimquyen
//leak canary
//proguard
//change color primary

@HiltAndroidApp
class GalaxyApp : MultiDexApplication() {

    @Inject
    lateinit var initializers: InitializersApp

    override fun onCreate() {
        super.onCreate()

        initializers.init(this)
    }
}
