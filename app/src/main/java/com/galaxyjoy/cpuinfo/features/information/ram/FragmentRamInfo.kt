package com.galaxyjoy.cpuinfo.features.information.ram

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.google.android.material.snackbar.Snackbar
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.databinding.FRecyclerViewBinding
import com.galaxyjoy.cpuinfo.features.information.base.BaseFragment
import com.galaxyjoy.cpuinfo.utils.runOnApiBelow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentRamInfo : BaseFragment<FRecyclerViewBinding>(R.layout.f_recycler_view) {

    private val viewModel: ViewModelRamInfo by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = RamInfoEpoxyController(requireContext())
        binding.recyclerView.adapter = controller.adapter

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                runOnApiBelow(24) {
                    menuInflater.inflate(R.menu.menu_ram, menu)
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.menuActionGc -> {
                        viewModel.onClearRamClicked()
                        Snackbar.make(
                            binding.mainContainer, getString(R.string.running_gc),
                            Snackbar.LENGTH_SHORT
                        ).show()
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.viewState.observe(viewLifecycleOwner) { controller.setData(it) }
    }
}
