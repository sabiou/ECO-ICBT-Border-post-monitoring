package com.sim2g.icbt.ui.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.Operateur
import com.sim2g.icbt.databinding.ItemOperatorBinding
import com.sim2g.icbt.databinding.ItemYearEvalHeaderBinding
import com.sim2g.icbt.ui.viewholders.OperatorViewHolder
import com.sim2g.icbt.ui.viewholders.YearOfEvalHeaderViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.skydoves.baserecyclerviewadapter.SectionRow

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
class OperatorsAdapter : BaseAdapter() {

    init {
        addSection(arrayListOf<Operateur>())
    }

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        when (layout) {
            R.layout.item_year_eval_header -> {
                val binding = ItemYearEvalHeaderBinding.inflate(LayoutInflater.from(view.context))
                return YearOfEvalHeaderViewHolder(binding)
            }
            R.layout.item_operator -> {
                val binding = ItemOperatorBinding.inflate(LayoutInflater.from(view.context))
                return OperatorViewHolder(binding)
            }
        }

        throw Resources.NotFoundException("not founded layout")
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_operator

    //override fun viewHolder(layout: Int, view: View): BaseViewHolder = OperatorViewHolder(view)
}