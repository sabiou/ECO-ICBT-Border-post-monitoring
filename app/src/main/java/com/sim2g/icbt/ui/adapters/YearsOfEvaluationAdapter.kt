package com.sim2g.icbt.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.databinding.ItemYearEvalHeaderBinding
import com.sim2g.icbt.databinding.ItemYearOfEvaluationBinding

/**
 * Created by Farouk Sabiou on 2/17/22.
 */

private const val HEADER = 1
private const val CONTENT = 2

class YearsOfEvaluationAdapter : ListAdapter<Annee, RecyclerView.ViewHolder>(CandidateDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return YearOfEvaluationViewHolder(
            ItemYearOfEvaluationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val candidate = getItem(position)
        (holder as YearOfEvaluationViewHolder).bind(candidate)
    }

    class YearOfEvaluationViewHolder(
        private val binding: ItemYearOfEvaluationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Annee) {
            binding.apply {
                annee = item
                executePendingBindings()
            }
        }
    }

    class HeaderViewHolder(
        private val binding: ItemYearEvalHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                textYear.text = "Year"
                textStartDate.text = "Start date"
                textEndDate.text = "End date"
                options.text = "Options"
                executePendingBindings()
            }
        }
    }

    private class CandidateDiffCallBack : DiffUtil.ItemCallback<Annee>() {
        override fun areItemsTheSame(oldItem: Annee, newItem: Annee): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Annee, newItem: Annee): Boolean {
            return oldItem == newItem
        }
    }
}