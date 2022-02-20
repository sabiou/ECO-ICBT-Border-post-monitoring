package com.sim2g.icbt.ui.viewholders

import android.view.View
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.databinding.ItemOperatorBinding
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

class OperatorsVH(
    private val binding: ItemOperatorBinding,
    //private val delegate: Delegate
) : BaseViewHolder(binding.root) {

    private lateinit var operatorItem: Operateur

//    interface Delegate {
//        fun onItemClick(yerItem: Annee)
//    }

    override fun bindData(data: Any) {
        if (data is Operateur) {
            this.operatorItem = data
            drawItem()
        }
    }

    private fun drawItem() {
        binding.apply {
            operator = operatorItem
            executePendingBindings()
        }
    }

    override fun onClick(v: View?) = Unit
    // override fun onClick(v: View?) = delegate.onItemClick(yearItem)

    override fun onLongClick(v: View?) = false

}
