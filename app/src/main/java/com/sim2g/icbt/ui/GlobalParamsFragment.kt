package com.sim2g.icbt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.FragmentGlobalParamsBinding
import com.sim2g.icbt.ui.adapters.BORDER_POST
import com.sim2g.icbt.ui.adapters.GlobalParamsPagerAdapter
import com.sim2g.icbt.ui.adapters.PERFORMANCE_KEY
import com.sim2g.icbt.ui.adapters.YEAR_OF_EVALUATION

class GlobalParamsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentGlobalParamsBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager
        // set adapter
        viewPager.adapter = GlobalParamsPagerAdapter(this)

        // set text on tabs
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            YEAR_OF_EVALUATION -> "Year Of Evaluation"
            PERFORMANCE_KEY -> "Performace Key"
            BORDER_POST -> "Border Post"
            else -> null
        }
    }
}