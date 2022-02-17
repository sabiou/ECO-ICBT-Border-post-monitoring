package com.sim2g.icbt.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentYearOfEvaluationBinding
import com.sim2g.icbt.ui.adapters.YearEvalHeaderAdapter
import com.sim2g.icbt.ui.adapters.YearsOfEvaluationAdapter
import com.sim2g.icbt.ui.viewmodels.YearOfEvaluationViewModel

class YearOfEvaluationFragment : Fragment() {

    private val viewModel: YearOfEvaluationViewModel by lazy {
        ViewModelProvider(this)[YearOfEvaluationViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentYearOfEvaluationBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.vm = viewModel

        val headerAdapter = YearEvalHeaderAdapter()
        val yearsAdapter = YearsOfEvaluationAdapter()
        val concatAdapter = ConcatAdapter(headerAdapter, yearsAdapter)

        binding.rvYofEval.adapter = yearsAdapter

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun showActive() {
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.year_of_evaluation_menu, menu);
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