package com.sim2g.icbt.ui.adapters

import com.robinhood.spark.SparkAdapter
import com.sim2g.icbt.data.model.Evaliovan
import com.sim2g.icbt.extensions.Utils

/**
 * Created by Farouk Sabiou on 3/4/22.
 */

class EvalSparkAdapter(private val evaliovanData: List<Evaliovan>) : SparkAdapter() {

    override fun getCount(): Int = evaliovanData.size

    override fun getItem(index: Int) = evaliovanData[index]

    override fun getY(index: Int): Float {
        val data = evaliovanData[index]
        val formattedValue = Utils.formatValue(data.valeur)
        return formattedValue.toFloat()
    }

//    override fun getX(index: Int): Float {
//        val data = evaliovanData[index]
//        return data.annee.toFloat()
//    }

}