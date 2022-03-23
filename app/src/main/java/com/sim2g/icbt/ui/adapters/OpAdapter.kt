package com.sim2g.icbt.ui.adapters

import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.databinding.ItemOperatorBinding
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding

/**
 * Created by Farouk Sabiou on 2/25/22.
 */
class OpAdapter(val onClickListener: OnClickListener ): BindingListAdapter<Operateur, OpAdapter.OpViewHolder>(DiffCallback) {

    inner class OpViewHolder constructor(private val binding: ItemOperatorBinding):
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                onClickListener.onClick(getItem(position))
            }
        }

        fun bindOperator(operateur: Operateur) {
            binding.operator = operateur
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpViewHolder =
        parent.binding<ItemOperatorBinding>(R.layout.item_operator).let(::OpViewHolder)

    override fun onBindViewHolder(holder: OpViewHolder, position: Int) =
        holder.bindOperator(getItem(position))

    companion object DiffCallback : DiffUtil.ItemCallback<Operateur>() {
        override fun areItemsTheSame(oldItem: Operateur, newItem: Operateur): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Operateur, newItem: Operateur): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class OnClickListener(val clickListener: (operateur: Operateur) -> Unit) {
        fun onClick(operateur:Operateur) = clickListener(operateur)
    }
}