package com.galaxyjoy.cpuinfo.features.applications

import android.net.Uri
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class ExtendedAppInfo(
    val name: String,
    val packageName: String,
    val sourceDir: String,
    val nativeLibraryDir: String?,
    val hasNativeLibs: Boolean,
    val appIconUri: Uri,
    var appSize: Long = 0
) : Parcelable
