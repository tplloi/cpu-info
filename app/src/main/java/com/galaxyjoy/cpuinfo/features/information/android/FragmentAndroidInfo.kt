package com.galaxyjoy.cpuinfo.features.information.android

import androidx.fragment.app.viewModels
import com.galaxyjoy.cpuinfo.features.information.base.AdapterInfoItems
import com.galaxyjoy.cpuinfo.features.information.base.BaseRvFragment
import com.galaxyjoy.cpuinfo.utils.DividerItemDecoration
import com.galaxyjoy.cpuinfo.utils.lifecycle.ListLiveDataObserver
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
