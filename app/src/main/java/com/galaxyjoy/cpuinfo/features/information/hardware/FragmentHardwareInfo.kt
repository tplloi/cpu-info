package com.galaxyjoy.cpuinfo.features.information.hardware

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.fragment.app.viewModels
import com.galaxyjoy.cpuinfo.features.information.base.BaseRvFragment
import com.galaxyjoy.cpuinfo.features.information.base.AdapterInfoItems
import com.galaxyjoy.cpuinfo.utils.DividerItemDecoration
import com.galaxyjoy.cpuinfo.utils.lifecycle.ListLiveDataObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHardwareInfo : BaseRvFragment() {

    private val viewModel: ViewModelHardwareInfo by viewModels()

    private val powerReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            viewModel.refreshHardwareInfo()
        }
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED")
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
        requireActivity().registerReceiver(powerReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        requireActivity().unregisterReceiver(powerReceiver)
    }

    override fun setupRecyclerViewAdapter() {
        val adapterInfoItems = AdapterInfoItems(
            viewModel.listLiveData,
            AdapterInfoItems.LayoutType.HORIZONTAL_LAYOUT, onClickListener = this
        )
        viewModel.listLiveData.listStatusChangeNotificator.observe(
            viewLifecycleOwner,
            ListLiveDataObserver(adapterInfoItems)
        )
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext()))
        recyclerView.adapter = adapterInfoItems
    }
}
