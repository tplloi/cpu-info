package com.galaxyjoy.cpuinfo.util

import androidx.lifecycle.MutableLiveData

/**
 * [MutableLiveData] with default value support.
 **/
class NonNullMutableLiveData<T>(defaultValue: T) : MutableLiveData<T>() {

    init {
        value = defaultValue
    }

    override fun getValue(): T {
        return super.getValue()!!
    }

    override fun setValue(value: T) {
        value ?: throw NullPointerException("Cannot set null value")
        super.setValue(value)
    }
}
