package com.galaxyjoy.cpuinfo.features

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.databinding.ActHostLayoutBinding
import com.galaxyjoy.cpuinfo.util.runOnApiAbove
import com.galaxyjoy.cpuinfo.util.setupEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint

/**
 * Base activity which is a host for whole application.
 **/
@AndroidEntryPoint
class AHost : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActHostLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppThemeBase)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.act_host_layout)
        setupEdgeToEdge()
        setupNavigation()
        setSupportActionBar(binding.toolbar)
        runOnApiAbove(Build.VERSION_CODES.M) {
            // Processes cannot be listed above M
            val menu = binding.bottomNavigation.menu
            menu.findItem(R.id.menuProcesses).isVisible = false
        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    private fun setupNavigation() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment)
                .navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            setToolbarTitleAndElevation(destination.label.toString())
        }
        binding.bottomNavigation.apply {
            setupWithNavController(navController)
            setOnItemReselectedListener {
                // Do nothing - TODO: scroll to top
            }
        }
    }

    /**
     * Set toolbar title and manage elevation in case of L+ devices and TabLayout
     */
    @SuppressLint("NewApi")
    private fun setToolbarTitleAndElevation(title: String) {
        binding.toolbar.title = title
        // binding.toolbar.isVisible = navController.currentDestination?.id != R.id.applications
        if (navController.currentDestination?.id == R.id.menuHardware) {
            binding.toolbar.elevation = 0f
        } else {
            binding.toolbar.elevation = resources.getDimension(R.dimen.elevation_height)
        }
    }
}
