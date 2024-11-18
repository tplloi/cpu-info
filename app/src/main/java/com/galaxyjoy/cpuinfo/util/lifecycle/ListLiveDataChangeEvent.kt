package com.galaxyjoy.cpuinfo.util.lifecycle

/**
 * Wrapper for [ListLiveData] changes which contains type of the change [ListLiveDataState], index
 * of the changes and count of affected items.
 *
 */
data class ListLiveDataChangeEvent(
    val listLiveDataState: ListLiveDataState,
    val startIndex: Int = -1,
    val itemCount: Int = -1
)
