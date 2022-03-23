package com.sim2g.icbt.ui.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.Evaliovan
import com.sim2g.icbt.databinding.FragmentDashboardBinding
import com.sim2g.icbt.extensions.Utils
import com.sim2g.icbt.ui.viewmodels.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.asFlow

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val viewModel: DashboardViewModel by viewModels()
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding
    private lateinit var lineChart: LineChart
    var entries = arrayListOf<Entry>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding?.lifecycleOwner = viewLifecycleOwner

        // Giving the binding access to the OverviewViewModel
        binding!!.viewModel = viewModel

        //setChartData()

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        return binding!!.root
    }

//    private fun setChartData() {
//        for (data in chartData) {
//            entries.add(Entry(data.annee.toFloat(), Utils.formatValue(data.valeur)))
//        }
//
//        val dataset = LineDataSet(entries, "Label")
//        dataset.color = R.color.green_500
//
//        val lineData = LineData(dataset)
//        lineChart = LineChart(context)
//        lineChart.data = lineData
//        lineChart.invalidate()
//    }
}