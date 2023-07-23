package com.roy93group.cpuinfo.features.information.storage

import androidx.annotation.Keep

/**
 * Container for storage items (e.g. Internal, External, SD)
 *
 */
@Keep
data class StorageItem(
    val type: String,
    val iconRes: Int,
    val storageTotal: Long,
    val storageUsed: Long
)
