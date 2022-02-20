package com.sim2g.icbt.ui.viewholders

import android.view.View
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.databinding.ItemOperatorBinding
import com.sim2g.icbt.databinding.ItemYearEvalHeaderBinding
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
class OperatorViewHolder(private val binding: ItemOperatorBinding) : BaseViewHolder(binding.root) {

    private lateinit var operatorItem: Operateur

    override fun bindData(data: Any) {
        if (data is Operateur) {
            this.operatorItem = data
            drawItemUI()
        }
    }

    private fun drawItemUI() {
        binding.apply {
            operator = operatorItem
            executePendingBindings()
        }
    }

    override fun onClick(p0: View?) {
        // To handle later
    }

    override fun onLongClick(p0: View?): Boolean = false
}