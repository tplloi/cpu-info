package com.roy93group.cpuinfo.di.modules

import com.roy93group.cpuinfo.appinitializers.AppInitializer
import com.roy93group.cpuinfo.appinitializers.InitializerEpoxy
import com.roy93group.cpuinfo.appinitializers.NativeToolsInitializer
import com.roy93group.cpuinfo.appinitializers.InitializerRamWidget
import com.roy93group.cpuinfo.appinitializers.InitializerRx
import com.roy93group.cpuinfo.appinitializers.InitializerTheme
import com.roy93group.cpuinfo.appinitializers.InitializerTimber
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {

    @Binds
    @IntoSet
    abstract fun provideNativeToolsInitializer(bind: NativeToolsInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideRxInitializer(bind: InitializerRx): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(bind: InitializerTimber): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideRamWidgetInitializer(bind: InitializerRamWidget): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideThemeInitializer(bind: InitializerTheme): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideEpoxyInitializer(bind: InitializerEpoxy): AppInitializer
}
