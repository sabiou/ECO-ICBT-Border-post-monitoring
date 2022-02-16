package com.sim2g.icbt.ui.item

import android.view.View
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.YearOfEvalHeaderBinding
import com.xwray.groupie.viewbinding.BindableItem


/**
 * Created by Farouk Sabiou on 2/16/22.
 */
class ItemYearEvalHeader : BindableItem<YearOfEvalHeaderBinding>() {
    override fun bind(viewBinding: YearOfEvalHeaderBinding, position: Int) {}

    override fun getLayout(): Int = R.layout.item_year_of_evaluation

    override fun initializeViewBinding(view: View): YearOfEvalHeaderBinding {
        return YearOfEvalHeaderBinding.bind(view)
    }
}