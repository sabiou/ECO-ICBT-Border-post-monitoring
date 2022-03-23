package com.sim2g.icbt.ui.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.data.model.BorderPost
import com.sim2g.icbt.data.model.IOV
import com.sim2g.icbt.data.model.Operateur

/**
 * Created by Farouk Sabiou on 2/17/22.
 */
@BindingAdapter("adapter")
fun bindYearsAdapter(view: RecyclerView, adapter: YearEvalAdapter) {
    view.adapter = adapter
}

@BindingAdapter("operatorsAdapter")
fun bindOperatorsAdapter(view: RecyclerView, adapter: OpAdapter) {
    view.adapter = adapter
}

@BindingAdapter("startDate")
fun bindStartDate(view: TextView, date: String) {
    "Start date: $date".also { view.text = it }
}

@BindingAdapter("endDate")
fun bindEndDate(view: TextView, date: String) {
    "End date: $date".also { view.text = it }
}

@BindingAdapter("yearsList")
fun bindRecyclerView(recyclerView: RecyclerView, years: List<Annee>) {
    val adapter = recyclerView.adapter as YearEvalAdapter
    adapter.submitList(years)
}

@BindingAdapter("isActive")
fun bindIsYearActive(view: ImageView, isActive: Boolean) {
    if (isActive) {
        view.setBackgroundResource(R.drawable.circle_green)
    } else {
        view.setBackgroundResource(R.drawable.circle_red)
    }
}

@BindingAdapter("statusText")
fun bindIsStatusText(view: TextView, isActive: Boolean) {
    if (isActive) {
        "active".also { view.text = it }
    } else {
        "inactive".also { view.text = it }
    }
}

@BindingAdapter("operatorsList")
fun bindOperatorsList(recyclerView: RecyclerView, operators: List<Operateur>) {
    val adapter = recyclerView.adapter as OpAdapter
    adapter.submitList(operators)
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    view.load(R.drawable.ic_baseline_account_circle_24) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }
}

@BindingAdapter("iovList")
fun bindIovList(recyclerView: RecyclerView, list: List<IOV>) {
    val adapter = recyclerView.adapter as IovAdapter
    adapter.submitList(list)
}

//@BindingAdapter("borderPostsList")
//fun bindBorderPostsList(recyclerView: RecyclerView, list: List<BorderPost>) {
//    val adapter = recyclerView.adapter as BorderPostAdapter
//    adapter.submitList(list)
//}
//
//@BindingAdapter("bordersAdapter")
//fun bindBorderPostAdapter(view: RecyclerView, adapter: BorderPostAdapter) {
//    view.adapter = adapter
//}

@BindingAdapter("periodicite")
fun bindIovPeriodicite(view: TextView, text: String) {
    "Periodicite: $text".also { view.text = it }
}

@BindingAdapter("iovCible")
fun bindIovCible(view: TextView, text: String) {
    "Max Point: $text".also { view.text = it }
}

// TIL: Use extension function for context dependant method like TextView's setTextColor()
@BindingAdapter("title")
fun TextView.titleColor(isActive: Boolean) {
    if (isActive) {
        this.setTextColor(context.getColor(R.color.green_500))
    } else {
        this.setTextColor(context.getColor(R.color.red_500))
    }
}
// bind view visibility
@BindingAdapter("gone")
fun bindVisibility(view: View, shouldBeGone: Boolean) {
    view.visibility = if (shouldBeGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}