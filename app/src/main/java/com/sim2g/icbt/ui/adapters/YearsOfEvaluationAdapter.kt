package com.sim2g.icbt.ui.adapters

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.databinding.ItemYearEvalHeaderBinding
import com.sim2g.icbt.databinding.ItemYearOfEvaluationBinding
import com.sim2g.icbt.ui.viewholders.YearOfEvalHeaderViewHolder
import com.sim2g.icbt.ui.viewholders.YearOfEvaluationViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.skydoves.baserecyclerviewadapter.SectionRow

/**
 * Created by Farouk Sabiou on 2/17/22.
 */

class YearsOfEvaluationAdapter : BaseAdapter() {

    init {
        addSection(arrayListOf<Annee>())
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addYearList(years: List<Annee>) {
        sections().first().run {
            clear()
            addAll(years)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow): Int {
        return when (sectionRow.row) {
            0 -> R.layout.item_year_eval_header
            else -> R.layout.item_year_of_evaluation
        }
    }

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        when (layout) {
            R.layout.item_year_eval_header -> {
                val binding = ItemYearEvalHeaderBinding.inflate(LayoutInflater.from(view.context))
                return YearOfEvalHeaderViewHolder(binding)
            }
            R.layout.item_year_of_evaluation -> {
                val binding = ItemYearOfEvaluationBinding.inflate(LayoutInflater.from(view.context))
                return YearOfEvaluationViewHolder(binding)
            }
        }
        throw Resources.NotFoundException("not founded layout")
    }

    // override fun layout(sectionRow: SectionRow) = R.layout.item_year_of_evaluation

    //override fun viewHolder(layout: Int, view: View) = PosterViewHolder(view)
}

//class YearsOfEvaluationAdapte : ListAdapter<Annee, RecyclerView.ViewHolder>(CandidateDiffCallBack()) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return YearOfEvaluationViewHolder(
//            ItemYearOfEvaluationBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val candidate = getItem(position)
//        (holder as YearOfEvaluationViewHolder).bind(candidate)
//    }
//
//    class YearOfEvaluationViewHolder(
//        private val binding: ItemYearOfEvaluationBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: Annee) {
//            binding.apply {
//                annee = item
//                executePendingBindings()
//            }
//        }
//    }
//
//    class HeaderViewHolder(
//        private val binding: ItemYearEvalHeaderBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//        fun bind() {
//            binding.apply {
//                textYear.text = "Year"
//                textStartDate.text = "Start date"
//                textEndDate.text = "End date"
//                options.text = "Options"
//                executePendingBindings()
//            }
//        }
//    }
//
//    private class CandidateDiffCallBack : DiffUtil.ItemCallback<Annee>() {
//        override fun areItemsTheSame(oldItem: Annee, newItem: Annee): Boolean {
//            return oldItem.id == newItem.id
//        }
//        override fun areContentsTheSame(oldItem: Annee, newItem: Annee): Boolean {
//            return oldItem == newItem
//        }
//    }
//}