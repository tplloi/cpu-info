package com.galaxyjoy.cpuinfo.feature.infor.cpu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.databinding.FrmRecyclerViewBinding
import com.galaxyjoy.cpuinfo.feature.infor.base.BaseFrm
import dagger.hilt.android.AndroidEntryPoint

/**
 * Displays information about device CPU taken form /proc/cpuinfo file
 *
 * @author galaxyjoy
 */
@AndroidEntryPoint
class FrmCpuInfo : BaseFrm<FrmRecyclerViewBinding>(R.layout.frm_recycler_view) {

    private val viewModel: ViewModelCpuInfo by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = CpuInfoEpoxyController(requireContext())
        binding.rv.adapter = controller.adapter
        viewModel.viewState.observe(viewLifecycleOwner) { controller.setData(it) }
    }
}
