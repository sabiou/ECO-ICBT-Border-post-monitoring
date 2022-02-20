package com.sim2g.icbt.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.data.model.Operateur
import com.skydoves.baserecyclerviewadapter.BaseAdapter

/**
 * Created by Farouk Sabiou on 2/17/22.
 */
@BindingAdapter("adapter")
fun bindYearsAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("operatorsAdapter")
fun bindOperatorsAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("yearsList")
fun bindRecyclerView(recyclerView: RecyclerView, years: List<Annee>) {
    val adapter = recyclerView.adapter as YearsOfEvaluationAdapter
    adapter.addYearList(years)
}

@BindingAdapter("operatorsList")
fun bindOperatorsList(recyclerView: RecyclerView, operators: List<Operateur>) {
    val adapter = recyclerView.adapter as OperatorsAdapter
    adapter.addOperatorsList(operators)
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    view.load(R.drawable.ic_baseline_account_circle_24) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }
}