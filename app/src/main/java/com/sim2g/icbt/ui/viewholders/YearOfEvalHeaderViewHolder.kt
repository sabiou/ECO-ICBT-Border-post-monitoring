package com.sim2g.icbt.ui.viewholders

import android.view.View
import com.sim2g.icbt.databinding.ItemYearEvalHeaderBinding
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
class YearOfEvalHeaderViewHolder(private val binding: ItemYearEvalHeaderBinding) :
    BaseViewHolder(binding.root) {

    override fun bindData(data: Any) {
        if (data is String) {
            binding.textYear.text = "Year"
            binding.textStartDate.text = data
            binding.textEndDate.text = data
            binding.options.text = data
        }
    }

    override fun onClick(v: View?) = Unit

    override fun onLongClick(v: View?) = false
}