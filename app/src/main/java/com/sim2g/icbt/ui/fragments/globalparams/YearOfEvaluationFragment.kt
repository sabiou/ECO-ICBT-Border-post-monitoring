package com.sim2g.icbt.ui.fragments.globalparams

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentYearOfEvaluationBinding
import com.sim2g.icbt.ui.adapters.YearEvalAdapter
import com.sim2g.icbt.ui.viewmodels.YearOfEvaluationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YearOfEvaluationFragment : Fragment() {

    private val viewModel: YearOfEvaluationViewModel by lazy {
        ViewModelProvider(this)[YearOfEvaluationViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentYearOfEvaluationBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.vm = viewModel

        binding.adapter = YearEvalAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun showActive() {
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.year_of_evaluation_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.addEvaluationYearFragment) {
            findNavController().navigate(R.id.addEvaluationYearFragment)
        } else if (item.itemId == R.id.show_active) {
            showActive()
        }
        return super.onOptionsItemSelected(item)
    }
}