package com.galaxyjoy.cpuinfo.feature.information

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.databinding.FrmInfoBinding
import com.galaxyjoy.cpuinfo.feature.information.base.BaseFragment
import com.galaxyjoy.cpuinfo.feature.information.base.AdapterInfoContainerState
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment which is base for all hardware and software information fragments
 *
 */
@AndroidEntryPoint
class FragmentInfoContainer : BaseFragment<FrmInfoBinding>(R.layout.frm_info) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AdapterInfoContainerState(this)
        binding.vp.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.vp) { tab: TabLayout.Tab, position: Int ->
            tab.text = resources.getText(adapter.getTitleRes(position))
        }.attach()
    }
}

