package com.roy93group.cpuinfo.features.information.cpu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.roy93group.cpuinfo.R
import com.roy93group.cpuinfo.databinding.FRecyclerViewBinding
import com.roy93group.cpuinfo.features.information.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Displays information about device CPU taken form /proc/cpuinfo file
 *
 * @author roy93group
 */
@AndroidEntryPoint
class FragmentCpuInfo : BaseFragment<FRecyclerViewBinding>(R.layout.f_recycler_view) {

    private val viewModel: ViewModelCpuInfo by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = CpuInfoEpoxyController(requireContext())
        binding.recyclerView.adapter = controller.adapter
        viewModel.viewState.observe(viewLifecycleOwner) { controller.setData(it) }
    }
}
