package com.sim2g.icbt.ui.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.data.model.Annee
import com.skydoves.baserecyclerviewadapter.BaseAdapter

/**
 * Created by Farouk Sabiou on 2/17/22.
 */

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("yearsList")
fun bindRecyclerView(recyclerView: RecyclerView, years: List<Annee>) {
    val adapter = recyclerView.adapter as YearsOfEvaluationAdapter
    adapter.addYearList(years)
}