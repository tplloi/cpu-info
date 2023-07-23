package com.roy93group.cpuinfo.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Dispatchers used by coroutines
 *
 * @author roy93group
 */
@Singleton
class DispatchersProvider @Inject constructor() {
    val main: CoroutineDispatcher = Dispatchers.Main
    val io: CoroutineDispatcher = Dispatchers.IO
}
