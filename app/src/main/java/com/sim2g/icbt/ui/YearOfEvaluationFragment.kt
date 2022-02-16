package com.sim2g.icbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentDashboardBinding
import com.sim2g.icbt.databinding.FragmentYearOfEvaluationBinding
import com.sim2g.icbt.ui.item.ItemHeader
import com.sim2g.icbt.ui.item.ItemYearEvalHeader
import com.sim2g.icbt.ui.viewmodels.YearOfEvaluationViewModel
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.viewbinding.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YearOfEvaluationFragment : Fragment() {

    private val viewModel: YearOfEvaluationViewModel by lazy {
        ViewModelProvider(this)[YearOfEvaluationViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentYearOfEvaluationBinding.bind(view)
        val adapter = GroupAdapter<GroupieViewHolder<*>>()
        binding.rvYofEval.layoutManager = LinearLayoutManager(requireContext())
        binding.rvYofEval.adapter = adapter

        viewModel.yearsOfEvaluation.observe(viewLifecycleOwner, Observer { yearsOfEval ->
            adapter.clear()
            val items = mutableListOf<Group>()

            val yearsOfEvalSections = Section(ItemHeader(R.string.evaluations_years))
            yearsOfEvalSections.add(ItemYearEvalHeader())

            items.add(yearsOfEvalSections)
            adapter.update(items)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDashboardBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        return binding.root
    }
}