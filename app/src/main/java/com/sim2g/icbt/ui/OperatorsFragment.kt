package com.sim2g.icbt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sim2g.icbt.databinding.FragmentOperatorsBinding
import com.sim2g.icbt.ui.adapters.OperatorsAdapter
import com.sim2g.icbt.ui.viewmodels.OperatorsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class OperatorsFragment : Fragment() {

    private val viewModel: OperatorsViewModel by lazy {
        ViewModelProvider(this)[OperatorsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOperatorsBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.adapter = OperatorsAdapter()

        return binding.root
    }
}