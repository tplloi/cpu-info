package com.galaxyjoy.cpuinfo.feature.infor.android

import androidx.fragment.app.viewModels
import com.galaxyjoy.cpuinfo.feature.infor.base.AdtInfoItems
import com.galaxyjoy.cpuinfo.feature.infor.base.BaseRvFragment
import com.galaxyjoy.cpuinfo.util.DividerItemDecoration
import com.galaxyjoy.cpuinfo.util.lifecycle.ListLiveDataObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FrmAndroidInfo : BaseRvFragment() {

    private val viewModel: VMAndroidInfo by viewModels()

    private lateinit var adtInfoItems: AdtInfoItems

    override fun setupRecyclerViewAdapter() {
        adtInfoItems = AdtInfoItems(
            viewModel.listLiveData,
            AdtInfoItems.LayoutType.HORIZONTAL_LAYOUT, onClickListener = this
        )
        viewModel.listLiveData.listStatusChangeNotificator.observe(
            viewLifecycleOwner,
            ListLiveDataObserver(adtInfoItems)
        )
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext()))
        recyclerView.adapter = adtInfoItems
    }
}
