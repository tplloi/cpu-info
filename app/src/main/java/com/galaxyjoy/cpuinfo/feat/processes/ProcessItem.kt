package com.galaxyjoy.cpuinfo.feat.processes

import androidx.annotation.Keep

/**
 * Domain model for processes
 **/
@Keep
data class ProcessItem(
    val name: String,
    val pid: String,
    val ppid: String,
    val niceness: String,
    val user: String,
    val rss: String,
    val vsize: String
)
