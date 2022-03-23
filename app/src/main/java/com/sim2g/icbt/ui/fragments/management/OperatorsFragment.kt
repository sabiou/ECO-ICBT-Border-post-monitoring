package com.sim2g.icbt.ui.fragments.management

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentOperatorsBinding
import com.sim2g.icbt.ui.adapters.OpAdapter
import com.sim2g.icbt.ui.viewmodels.OperatorsViewModel
import dagger.hilt.android.AndroidEntryPoint

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

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        binding.adapter = OpAdapter(OpAdapter.OnClickListener {
            viewModel.displayOperatorDetails(it)
        })

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.addEditOperatorFragment)
        }

        viewModel.navigateToSelectedOperator.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                // Must find the NavController from the Fragment
                this.findNavController()
                    .navigate(OperatorsFragmentDirections.actionShowOperatorDetails(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                // viewModel.displayPropertyDetailsComplete()
            }
        })

        return binding.root
    }
}