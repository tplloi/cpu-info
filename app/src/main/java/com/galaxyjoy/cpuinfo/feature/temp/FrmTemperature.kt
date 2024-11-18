package com.galaxyjoy.cpuinfo.feature.temp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.databinding.FrmTemperatureBinding
import com.galaxyjoy.cpuinfo.feature.infor.base.BaseFrm
import com.galaxyjoy.cpuinfo.feature.temp.list.AdtTemperature
import com.galaxyjoy.cpuinfo.util.lifecycle.ListLiveDataObserver
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FrmTemperature : BaseFrm<FrmTemperatureBinding>(
    R.layout.frm_temperature
) {

    private val viewModel: TemperatureVM by viewModels()

    @Inject
    lateinit var temperatureFormatter: TemperatureFormatter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        setupRecycleView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.startTemperatureRefreshing()
    }

    override fun onStop() {
        viewModel.stopTemperatureRefreshing()
        super.onStop()
    }

    private fun setupRecycleView() {
        val adtTemperature = AdtTemperature(
            temperatureFormatter,
            viewModel.temperatureListLiveData
        )
        viewModel.temperatureListLiveData.listStatusChangeNotificator.observe(
            viewLifecycleOwner,
            ListLiveDataObserver(adtTemperature)
        )
        binding.apply {
            tempRv.layoutManager = LinearLayoutManager(requireContext())
            tempRv.adapter = adtTemperature
            (tempRv.itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
        }
    }
}
