package com.sim2g.icbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentDashboardBinding
import com.sim2g.icbt.databinding.FragmentManagementBinding
import com.sim2g.icbt.ui.adapters.OperatorsAdapter
import com.sim2g.icbt.ui.viewmodels.OperatorsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ManagementFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentManagementBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.btnUserMgmt.setOnClickListener { navigateToUserMgmt() }

        return binding.root

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
    }

    private fun navigateToUserMgmt() {
        findNavController().navigate(R.id.operatorsFragment)
    }
}