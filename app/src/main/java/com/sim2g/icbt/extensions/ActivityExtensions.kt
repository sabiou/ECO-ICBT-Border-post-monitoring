package com.sim2g.icbt.extensions

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Farouk Sabiou on 3/21/22.
 */

fun AppCompatActivity.goToActivty(context: Context, clss: Class<*>) {
    this.startActivity(Intent(context, clss))
}