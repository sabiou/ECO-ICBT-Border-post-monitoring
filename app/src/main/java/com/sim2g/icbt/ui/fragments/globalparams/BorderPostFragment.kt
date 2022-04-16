package com.sim2g.icbt.ui.fragments.globalparams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.BorderPost
import com.sim2g.icbt.databinding.FragmentBorderPostBinding
import com.sim2g.icbt.databinding.FragmentPerformanceKeyBinding
import com.sim2g.icbt.ui.adapters.BorderPostAdapter
import com.sim2g.icbt.ui.adapters.IovAdapter
import com.sim2g.icbt.ui.viewmodels.BorderPostViewModel
import com.sim2g.icbt.ui.viewmodels.IovViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class BorderPostFragment : Fragment() {
    private lateinit var currentlyShownData: List<BorderPost>

    private val viewModel: BorderPostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBorderPostBinding.inflate(inflater)

        val countries = listOf(
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
                viewModel.getBorderPostByCountry(selectedCountry)
            }
        }

        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        val adapter = BorderPostAdapter()

        binding.adapter = adapter
        // adapter.submitList(viewModel.borderPosts)

        adapter.notifyDataSetChanged()

        return binding.root
    }
}