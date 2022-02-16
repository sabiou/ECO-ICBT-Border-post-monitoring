package com.sim2g.icbt.ui.item

import android.view.View
import androidx.annotation.StringRes
import com.sim2g.icbt.R
import com.sim2g.icbt.databinding.ItemHeaderBinding
import com.xwray.groupie.viewbinding.BindableItem

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
class ItemHeader(@StringRes private val titleRes: Int) : BindableItem<ItemHeaderBinding>() {
    override fun getLayout() = R.layout.item_header

    override fun bind(viewBinding: ItemHeaderBinding, position: Int) {
        with(viewBinding) {
            title.setText(titleRes)
        }
    }

    override fun initializeViewBinding(view: View): ItemHeaderBinding {
        return ItemHeaderBinding.bind(view)
    }
}