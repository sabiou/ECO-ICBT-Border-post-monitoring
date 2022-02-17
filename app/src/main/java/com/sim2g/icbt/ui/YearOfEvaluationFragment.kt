package com.sim2g.icbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
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

        return binding.root
    }
}