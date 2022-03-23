package com.sim2g.icbt.ui.viewholders

import android.view.View
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.databinding.ItemYearOfEvaluationBinding
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

/**
 * Created by Farouk Sabiou on 2/19/22.
 */

class YearOfEvaluationViewHolder(
    private val binding: ItemYearOfEvaluationBinding,
    //private val delegate: Delegate
) : BaseViewHolder(binding.root) {

    private lateinit var yearItem: Annee

//    interface Delegate {
//        fun onItemClick(yerItem: Annee)
//    }

    override fun bindData(data: Any) {
        if (data is Annee) {
            this.yearItem = data
            binding.year.text = data.annee
            drawItem()
        }
    }

    private fun drawItem() {
       binding.apply {
           annee = yearItem
           executePendingBindings()
       }
    }

    override fun onClick(v: View?) = Unit
    // override fun onClick(v: View?) = delegate.onItemClick(yearItem)

    override fun onLongClick(v: View?) = false
}