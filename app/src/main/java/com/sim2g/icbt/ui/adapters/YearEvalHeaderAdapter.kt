package com.sim2g.icbt.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.ItemYearEvalHeaderBinding

/**
 * Created by Farouk Sabiou on 2/17/22.
 */
class YearEvalHeaderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HeaderViewHolder(
            ItemYearEvalHeaderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HeaderViewHolder).bind()
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

    override fun getItemCount(): Int = 1
}