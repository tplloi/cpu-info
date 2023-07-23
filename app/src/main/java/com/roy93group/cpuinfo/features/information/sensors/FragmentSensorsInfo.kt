package com.roy93group.cpuinfo.features.information.sensors

import androidx.fragment.app.viewModels
import com.roy93group.cpuinfo.features.information.base.BaseRvFragment
import com.roy93group.cpuinfo.features.information.base.InfoItemsAdapter
import com.roy93group.cpuinfo.utils.DividerItemDecoration
import com.roy93group.cpuinfo.utils.lifecycle.ListLiveDataObserver
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
        val infoItemsAdapter = InfoItemsAdapter(
            viewModel.listLiveData,
            InfoItemsAdapter.LayoutType.VERTICAL_LAYOUT, onClickListener = this
        )
        viewModel.listLiveData.listStatusChangeNotificator.observe(
            viewLifecycleOwner,
            ListLiveDataObserver(infoItemsAdapter)
        )
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext()))
        recyclerView.adapter = infoItemsAdapter
    }
}
