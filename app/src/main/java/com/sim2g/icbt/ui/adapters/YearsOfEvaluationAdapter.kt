package com.sim2g.icbt.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.databinding.ItemYearOfEvaluationBinding

/**
 * Created by Farouk Sabiou on 2/17/22.
 */

class YearsOfEvaluationAdapter : ListAdapter<Annee, RecyclerView.ViewHolder>(CandidateDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CandidateViewHolder(
            ItemYearOfEvaluationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val candidate = getItem(position)
        (holder as CandidateViewHolder).bind(candidate)
    }
    class CandidateViewHolder(
        private val binding: ItemYearOfEvaluationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Annee) {
            binding.apply {
                annee = item
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