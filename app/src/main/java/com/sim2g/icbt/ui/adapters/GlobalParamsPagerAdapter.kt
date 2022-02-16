package com.sim2g.icbt.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sim2g.icbt.ui.BorderPostFragment
import com.sim2g.icbt.ui.PerformanceKeyFragment
import com.sim2g.icbt.ui.YearOfEvaluationFragment

/**
 * Created by Farouk Sabiou on 2/16/22.
 */

const val YEAR_OF_EVALUATION = 0
const val PERFORMANCE_KEY = 1
const val BORDER_POST = 2

class GlobalParamsPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    // Mapping of the ViewPager page indexes to their respective Fragments
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        YEAR_OF_EVALUATION to { YearOfEvaluationFragment() },
        PERFORMANCE_KEY to { PerformanceKeyFragment() },
        BORDER_POST to { BorderPostFragment() },
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}