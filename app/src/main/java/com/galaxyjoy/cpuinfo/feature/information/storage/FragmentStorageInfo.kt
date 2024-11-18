package com.galaxyjoy.cpuinfo.feature.information.storage

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.viewModels
import com.galaxyjoy.cpuinfo.feature.information.base.BaseRvFragment
import com.galaxyjoy.cpuinfo.util.lifecycle.ListLiveDataObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentStorageInfo : BaseRvFragment() {

    private var receiverRegistered = false

    private val handler = Handler(Looper.getMainLooper())
    private val mountedReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            handler.removeCallbacksAndMessages(null)
            handler.postDelayed({ viewModel.refreshSdCard() }, 2000)
        }
    }

    private val viewModel: StorageInfoViewModel by viewModels()

    override fun onResume() {
        super.onResume()

        // Register events connected with inserting SD card
        if (!receiverRegistered) {
            receiverRegistered = true
            val filter = IntentFilter()
            filter.addAction(Intent.ACTION_MEDIA_BAD_REMOVAL)
            filter.addAction(Intent.ACTION_MEDIA_CHECKING)
            filter.addAction(Intent.ACTION_MEDIA_EJECT)
            filter.addAction(Intent.ACTION_MEDIA_MOUNTED)
            filter.addAction(Intent.ACTION_MEDIA_NOFS)
            filter.addAction(Intent.ACTION_MEDIA_REMOVED)
            filter.addAction(Intent.ACTION_MEDIA_SHARED)
            filter.addAction(Intent.ACTION_MEDIA_UNMOUNTABLE)
            filter.addAction(Intent.ACTION_MEDIA_UNMOUNTED)
            filter.addDataScheme("file")
            requireActivity().registerReceiver(mountedReceiver, filter)
        }
    }

    override fun onPause() {
        if (receiverRegistered) {
            receiverRegistered = false
            requireActivity().unregisterReceiver(mountedReceiver)
            handler.removeCallbacksAndMessages(null)
        }

        super.onPause()
    }

    override fun setupRecyclerViewAdapter() {
        val adapterStorage = AdapterStorage(viewModel.listLiveData)
        viewModel.listLiveData.listStatusChangeNotificator.observe(
            viewLifecycleOwner,
            ListLiveDataObserver(adapterStorage)
        )
        recyclerView.adapter = adapterStorage
    }
}
