package com.roy93group.cpuinfo.utils.lifecycle

/**
 * Representation of all possible list state changes
 *
 */
enum class ListLiveDataState {
    CHANGED,                // change of unknown type has occurred
    ITEM_RANGE_CHANGED,     // one or more items in the list have changed
    ITEM_RANGE_INSERTED,    // items have been inserted into the list
    ITEM_RANGE_REMOVED      // items in the list have been deleted
}
