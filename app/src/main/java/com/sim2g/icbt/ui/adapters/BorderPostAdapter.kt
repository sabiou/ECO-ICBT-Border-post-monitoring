package com.sim2g.icbt.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.BorderPost
import com.sim2g.icbt.databinding.ItemBorderPostBinding
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding

/**
 * Created by Farouk Sabiou on 3/22/22.
 */
class BorderPostAdapter: BindingListAdapter<BorderPost, BorderPostAdapter.BorderPostViewHolder>(DiffCallback) {

    class BorderPostViewHolder constructor(private val binding: ItemBorderPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindPost(post: BorderPost) {
            binding.borderPost = post
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: BorderPostViewHolder, position: Int) =
        holder.bindPost(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BorderPostViewHolder =
        parent.binding<ItemBorderPostBinding>(R.layout.item_border_post).let(::BorderPostViewHolder)

    companion object DiffCallback : DiffUtil.ItemCallback<BorderPost>() {
        override fun areItemsTheSame(oldItem: BorderPost, newItem: BorderPost): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BorderPost, newItem: BorderPost): Boolean {
            return oldItem.posteid == newItem.posteid
        }

    }
}