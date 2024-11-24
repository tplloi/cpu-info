package com.galaxyjoy.cpuinfo

import androidx.multidex.MultiDexApplication
import com.galaxyjoy.cpuinfo.appinitializers.InitializersApp
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

//TODO roy93~ why you see ad
//TODO roy93~ vung bi mat de show applovin config
//TODO roy93~ ad applovin
//TODO roy93~ firebase
//TODO roy93~ add lottie trang tri cho dep
//TODO roy93~ github

//splash screen
//gen ic_launcher https://easyappicon.com/
//keystore
//rename app
//license
//leak canary
//proguard
//font scale
//them version o man hinh chu
//rate, more, share, fb fan page, policy
//leak canary
//proguard

@HiltAndroidApp
class GalaxyApp : MultiDexApplication() {

    @Inject
    lateinit var initializers: InitializersApp

    override fun onCreate() {
        super.onCreate()

        initializers.init(this)
    }
}
