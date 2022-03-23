package com.sim2g.icbt.ui.fragments.globalparams

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.sim2g.icbt.databinding.FragmentAddEvaluationYearBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEvaluationYearFragment : Fragment() {

    private var _binding: FragmentAddEvaluationYearBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddEvaluationYearBinding.inflate(inflater)

        // add new year
        binding.btnAddYear.setOnClickListener {
            // to do : add a new year
        }
        return binding.root
    }
}