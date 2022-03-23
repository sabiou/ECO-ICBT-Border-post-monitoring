package com.sim2g.icbt.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.IOV
import com.sim2g.icbt.databinding.ItemIovBinding
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding

/**
 * Created by Farouk Sabiou on 3/21/22.
 */
class IovAdapter : BindingListAdapter<IOV, IovAdapter.IovViewholder>(DiffCallback) {

    class IovViewholder constructor(private val binding: ItemIovBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binIov(iov: IOV) {
            binding.iov = iov
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: IovViewholder, position: Int) =
        holder.binIov(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IovViewholder =
        parent.binding<ItemIovBinding>(R.layout.item_iov).let(::IovViewholder)

    companion object DiffCallback : DiffUtil.ItemCallback<IOV>() {
        override fun areItemsTheSame(oldItem: IOV, newItem: IOV): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: IOV, newItem: IOV): Boolean {
            return oldItem.idIov == newItem.idIov
        }

    }
}
