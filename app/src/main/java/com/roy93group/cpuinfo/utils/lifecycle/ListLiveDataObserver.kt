package com.roy93group.cpuinfo.utils.lifecycle

import android.annotation.SuppressLint
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

class ListLiveDataObserver(val adapter: RecyclerView.Adapter<*>) :
    Observer<ListLiveDataChangeEvent> {

    @SuppressLint("NotifyDataSetChanged")
    override fun onChanged(value: ListLiveDataChangeEvent) {
        when (value.listLiveDataState) {
            ListLiveDataState.CHANGED ->
                adapter.notifyDataSetChanged()

            ListLiveDataState.ITEM_RANGE_CHANGED ->
                adapter.notifyItemRangeChanged(value.startIndex, value.itemCount)

            ListLiveDataState.ITEM_RANGE_INSERTED ->
                adapter.notifyItemRangeInserted(value.startIndex, value.itemCount)

            ListLiveDataState.ITEM_RANGE_REMOVED ->
                adapter.notifyItemRangeRemoved(value.startIndex, value.itemCount)
        }
    }
}
