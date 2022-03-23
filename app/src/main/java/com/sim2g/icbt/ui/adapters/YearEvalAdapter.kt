package com.sim2g.icbt.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.databinding.ItemYearOfEvaluationBinding
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding

/**
 * Created by Farouk Sabiou on 2/25/22.
 */
class YearEvalAdapter : BindingListAdapter<Annee, YearEvalAdapter.YearEvalViewHolder>(DiffCallback) {

    inner class YearEvalViewHolder constructor(private val binding: ItemYearOfEvaluationBinding):
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
            }
        }

        fun bindYear (annee: Annee) {
            binding.annee = annee
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearEvalViewHolder =
        parent.binding<ItemYearOfEvaluationBinding>(R.layout.item_year_of_evaluation).let(::YearEvalViewHolder)

    override fun onBindViewHolder(holder: YearEvalViewHolder, position: Int) =
        holder.bindYear(getItem(position))

    companion object DiffCallback : DiffUtil.ItemCallback<Annee>() {
        override fun areItemsTheSame(oldItem: Annee, newItem: Annee): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Annee, newItem: Annee): Boolean {
            return oldItem.id == newItem.id
        }
    }
}