package com.galaxyjoy.cpuinfo.utils.wrappers

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class MyResult<out R> {

    data class Success<out T>(val data: T) : MyResult<T>()
    data class Error(val throwable: Throwable) : MyResult<Nothing>()
    object Loading : MyResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[throwable=$throwable]"
            Loading -> "Loading"
        }
    }

    /**
     * This function combines status only of two results into one. This is useful when only
     * status is needed (Loading/Success/Error) but nothing else is needed.
     */
    fun <S> combineStatusOnlyWith(secondMyResult: MyResult<S>): MyResult<Unit> {
        return when {
            this is Success && secondMyResult is Success -> Success(Unit)
            this is Loading || secondMyResult is Loading -> Loading
            else -> Error(ResultCombinationException())
        }
    }

    class ResultCombinationException : Exception()
}
