package com.sim2g.icbt.extensions

import android.view.View

/**
 * Created by Farouk Sabiou on 2/22/22.
 */

// show
fun View.visible() {
    visibility = View.VISIBLE
}

// set to gone
fun View.gone() {
    visibility = View.GONE
}