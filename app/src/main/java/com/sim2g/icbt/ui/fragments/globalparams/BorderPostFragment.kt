package com.sim2g.icbt.ui.fragments.globalparams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.asFlow
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentBorderPostBinding
import com.sim2g.icbt.databinding.FragmentPerformanceKeyBinding
import com.sim2g.icbt.ui.adapters.BorderPostAdapter
import com.sim2g.icbt.ui.adapters.IovAdapter
import com.sim2g.icbt.ui.viewmodels.BorderPostViewModel
import com.sim2g.icbt.ui.viewmodels.IovViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BorderPostFragment : Fragment() {

    private val viewModel: BorderPostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBorderPostBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.vm = viewModel

        val countries = listOf(
            "benin",
            "burkina",
            "capvert",
            "cotedivoire",
            "gambie",
            "ghana",
            "guineebissau",
            "guinnee",
            "liberia",
            "mali",
            "maroc",
            "mauritanie",
            "niger",
            "nigeria",
            "senegal",
            "sierraleon",
            "soudan",
            "tchad",
            "togo"
        )
        binding.countrySpinner.apply {
            attachDataSource(countries)
            setOnSpinnerItemSelectedListener { parent, _, position, _ ->
                val selectedCountry = parent.getItemAtPosition(position) as String
                // viewModel.getBorderPostByCountry(selectedCountry)
            }
        }
        return binding.root
    }
}