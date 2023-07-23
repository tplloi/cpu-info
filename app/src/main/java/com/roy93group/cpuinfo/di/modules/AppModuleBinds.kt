package com.roy93group.cpuinfo.di.modules

import com.roy93group.cpuinfo.appinitializers.AppInitializer
import com.roy93group.cpuinfo.appinitializers.EpoxyInitializer
import com.roy93group.cpuinfo.appinitializers.NativeToolsInitializer
import com.roy93group.cpuinfo.appinitializers.RamWidgetInitializer
import com.roy93group.cpuinfo.appinitializers.RxInitializer
import com.roy93group.cpuinfo.appinitializers.ThemeInitializer
import com.roy93group.cpuinfo.appinitializers.TimberInitializer
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
    abstract fun provideRxInitializer(bind: RxInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(bind: TimberInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideRamWidgetInitializer(bind: RamWidgetInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideThemeInitializer(bind: ThemeInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideEpoxyInitializer(bind: EpoxyInitializer): AppInitializer
}
