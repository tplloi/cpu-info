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

//TODO change color primary
//TODO icon launcher
//TODO keystore
//TODO rate, more, share, fb fan page, policy
//TODO firebase
//TODO proguard
//TODO leak canary
//TODO ad applovin

//done

@HiltAndroidApp
class MyApp : MultiDexApplication() {

    @Inject
    lateinit var initializers: InitializersApp

    override fun onCreate() {
        super.onCreate()

        initializers.init(this)
    }
}
