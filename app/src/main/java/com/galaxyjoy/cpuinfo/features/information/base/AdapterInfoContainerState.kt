package com.galaxyjoy.cpuinfo.features.information.base

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.features.information.android.FragmentAndroidInfo
import com.galaxyjoy.cpuinfo.features.information.cpu.FragmentCpuInfo
import com.galaxyjoy.cpuinfo.features.information.gpu.FragmentGpuInfo
import com.galaxyjoy.cpuinfo.features.information.hardware.FragmentHardwareInfo
import com.galaxyjoy.cpuinfo.features.information.ram.FragmentRamInfo
import com.galaxyjoy.cpuinfo.features.information.screen.FragmentScreenInfo
import com.galaxyjoy.cpuinfo.features.information.sensors.FragmentSensorsInfo
import com.galaxyjoy.cpuinfo.features.information.storage.FragmentStorageInfo

/**
 * Simple view pager for info fragments
 */
class AdapterInfoContainerState(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment =
        when (position) {
            CPU_POS -> FragmentCpuInfo()
            GPU_POS -> FragmentGpuInfo()
            RAM_POS -> FragmentRamInfo()
            STORAGE_POS -> FragmentStorageInfo()
            SCREEN_POS -> FragmentScreenInfo()
            ANDROID_POS -> FragmentAndroidInfo()
            HARDWARE_POS -> FragmentHardwareInfo()
            SENSORS_POS -> FragmentSensorsInfo()
            else -> throw IllegalArgumentException("Unknown position for ViewPager2")
        }

    override fun getItemCount(): Int = INFO_PAGE_AMOUNT

    fun getTitleRes(position: Int) = when (position) {
        CPU_POS -> R.string.cpu
        GPU_POS -> R.string.gpu
        RAM_POS -> R.string.ram
        STORAGE_POS -> R.string.storage
        SCREEN_POS -> R.string.screen
        ANDROID_POS -> R.string.android
        HARDWARE_POS -> R.string.hardware
        SENSORS_POS -> R.string.sensors
        else -> throw IllegalArgumentException("Unknown position for ViewPager2")
    }

    companion object {
        private const val CPU_POS = 0
        private const val GPU_POS = 1
        private const val RAM_POS = 2
        private const val STORAGE_POS = 3
        private const val SCREEN_POS = 4
        private const val ANDROID_POS = 5
        private const val HARDWARE_POS = 6
        private const val SENSORS_POS = 7

        private const val INFO_PAGE_AMOUNT = 8
    }
}
