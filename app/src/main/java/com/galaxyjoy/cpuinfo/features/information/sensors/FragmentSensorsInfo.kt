package com.galaxyjoy.cpuinfo.features.information.sensors

import androidx.fragment.app.viewModels
import com.galaxyjoy.cpuinfo.features.information.base.BaseRvFragment
import com.galaxyjoy.cpuinfo.features.information.base.AdapterInfoItems
import com.galaxyjoy.cpuinfo.utils.DividerItemDecoration
import com.galaxyjoy.cpuinfo.utils.lifecycle.ListLiveDataObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSensorsInfo : BaseRvFragment() {

    private val viewModel: ViewModelSensorsInfo by viewModels()

    override fun onStart() {
        super.onStart()
        viewModel.startProvidingData()
    }

    override fun onStop() {
        viewModel.stopProvidingData()
        super.onStop()
    }

    override fun setupRecyclerViewAdapter() {
        val adapterInfoItems = AdapterInfoItems(
            viewModel.listLiveData,
            AdapterInfoItems.LayoutType.VERTICAL_LAYOUT, onClickListener = this
        )
        viewModel.listLiveData.listStatusChangeNotificator.observe(
            viewLifecycleOwner,
            ListLiveDataObserver(adapterInfoItems)
        )
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext()))
        recyclerView.adapter = adapterInfoItems
    }
}
