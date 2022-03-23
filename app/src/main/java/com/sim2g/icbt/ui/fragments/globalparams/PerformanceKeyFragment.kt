package com.sim2g.icbt.ui.fragments.globalparams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.sim2g.icbt.databinding.FragmentPerformanceKeyBinding
import com.sim2g.icbt.ui.adapters.IovAdapter
import com.sim2g.icbt.ui.viewmodels.IovViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PerformanceKeyFragment : Fragment() {

    private val viewModel: IovViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPerformanceKeyBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.vm = viewModel

        binding.adapter = IovAdapter()

        return binding.root
    }
}