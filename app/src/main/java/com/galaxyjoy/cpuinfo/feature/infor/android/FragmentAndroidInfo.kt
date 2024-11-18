package com.galaxyjoy.cpuinfo.feature.infor.android

import androidx.fragment.app.viewModels
import com.galaxyjoy.cpuinfo.feature.infor.base.AdapterInfoItems
import com.galaxyjoy.cpuinfo.feature.infor.base.BaseRvFragment
import com.galaxyjoy.cpuinfo.util.DividerItemDecoration
import com.galaxyjoy.cpuinfo.util.lifecycle.ListLiveDataObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAndroidInfo : BaseRvFragment() {

    private val viewModel: ViewModelAndroidInfo by viewModels()

    private lateinit var adapterInfoItems: AdapterInfoItems

    override fun setupRecyclerViewAdapter() {
        adapterInfoItems = AdapterInfoItems(
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
