package com.sim2g.icbt.ui.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.data.model.Annee

/**
 * Created by Farouk Sabiou on 2/17/22.
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Annee>?) {
    val adapter = recyclerView.adapter as YearsOfEvaluationAdapter
    adapter.submitList(data)
}