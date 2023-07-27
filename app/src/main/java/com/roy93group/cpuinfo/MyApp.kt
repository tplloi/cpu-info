package com.roy93group.cpuinfo

import androidx.multidex.MultiDexApplication
import com.roy93group.cpuinfo.appinitializers.InitializersApp
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * Base Application class for required initializations
 *
 * @author roy93group
 */

//TODO ad applovin
//TODO firebase

//done
//icon launcher
//leak canary
//proguard
//rate, more, share, fb fan page, policy
//change color primary
//keystore

@HiltAndroidApp
class MyApp : MultiDexApplication() {

    @Inject
    lateinit var initializers: InitializersApp

    override fun onCreate() {
        super.onCreate()

        initializers.init(this)
    }
}
