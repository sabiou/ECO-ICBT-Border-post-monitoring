package com.sim2g.icbt.ui.item

import android.view.View
import com.sim2g.icbt.R
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.databinding.ItemYearOfEvaluationBinding
import com.xwray.groupie.viewbinding.BindableItem

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
class ItemYearOfEvaluation constructor(private val annee: Annee): BindableItem<ItemYearOfEvaluationBinding>() {
    override fun bind(viewBinding: ItemYearOfEvaluationBinding, position: Int) {
        viewBinding.annee = annee
        viewBinding.executePendingBindings()
    }

    override fun getLayout(): Int = R.layout.item_year_of_evaluation

    override fun initializeViewBinding(view: View): ItemYearOfEvaluationBinding {
        return ItemYearOfEvaluationBinding.bind(view)
    }

}