package com.roy93group.cpuinfo.domain.model

enum class SortOrder {
    ASCENDING, DESCENDING, NONE
}

fun sortOrderFromBoolean(isAscending: Boolean): SortOrder =
    if (isAscending) SortOrder.ASCENDING else SortOrder.DESCENDING