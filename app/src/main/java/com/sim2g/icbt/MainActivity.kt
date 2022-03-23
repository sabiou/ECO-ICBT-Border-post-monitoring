package com.sim2g.icbt

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.sim2g.icbt.databinding.ActivityMainBinding
import com.sim2g.icbt.extensions.gone
import com.sim2g.icbt.extensions.visible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private lateinit var binding: ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


//        if (sharedPreferences.getBoolean("loggedIn", false)) {
//            moveToMainScreen()
//        }

        // setup the bottom navigation view
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // hide/show views across screens
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.dashboardFragment, R.id.globalParamsFragment, R.id.managementFragment
                -> {
                    binding.bottomNavigation.visible()
                    //binding.fabAdd.visible()
                }
                else -> {
                    binding.bottomNavigation.gone()
                    binding.fabAdd.gone()
                }
            }
        }
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }

    private fun moveToMainScreen() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.dashboardFragment)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment).navigateUp()
}