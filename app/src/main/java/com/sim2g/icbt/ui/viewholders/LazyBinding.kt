package com.sim2g.icbt.ui.viewholders

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
inline fun <reified T : ViewDataBinding> BaseViewHolder.bindings(): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE) {
        requireNotNull(DataBindingUtil.bind(itemView)) { "cannot find the matched view to layout." }
    }