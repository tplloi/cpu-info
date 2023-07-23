package com.roy93group.cpuinfo.domain.model

import android.net.Uri
import androidx.annotation.Keep
import androidx.compose.runtime.Stable

@Keep
data class ExtendedApplicationData(
    val name: String,
    val packageName: String,
    val sourceDir: String,
    val nativeLibraryDir: String?,
    val hasNativeLibs: Boolean,
    @Stable val appIconUri: Uri,
    val appSize: Long = 0
)
