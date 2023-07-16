package com.roy93group.cpuinfo.utils

import com.roy93group.cpuinfo.utils.wrappers.MyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

/**
 * Wrap passed [block] with [MyResult]. Flow will always start with [MyResult.Loading] and finish
 * with [MyResult.Success] in case of success otherwise it will emit [MyResult.Error].
 */
fun <T> wrapToResultFlow(block: suspend () -> T): Flow<MyResult<T>> = flow {
    emit(MyResult.Loading)
    try {
        val result = block()
        emit(MyResult.Success(result))
    } catch (throwable: Throwable) {
        Timber.e(throwable)
        emit(MyResult.Error(throwable))
    }
}

/**
 * Create flow from suspended function wrapped with [MyResult]. Flow will always start with
 * [MyResult.Loading] and finish with [MyResult.Success] in case of success otherwise it will emit
 * [MyResult.Error].
 */
fun <T> (suspend () -> T).asResultFlow(): Flow<MyResult<T>> = flow {
    emit(MyResult.Loading)
    try {
        val result = invoke()
        emit(MyResult.Success(result))
    } catch (throwable: Throwable) {
        Timber.e(throwable)
        emit(MyResult.Error(throwable))
    }
}