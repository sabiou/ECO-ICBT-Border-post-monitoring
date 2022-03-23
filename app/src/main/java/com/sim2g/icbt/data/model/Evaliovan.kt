package com.sim2g.icbt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "evaliovan")
data class Evaliovan(var annee: Int, var valeur: String) {
    @PrimaryKey
    var id: String = ""
    var datecre: String = ""
    var datemaj: String = ""
    var idiov: String = ""
    var idposte: String = ""
    var observation: String = ""
    var opcre: String = ""
    var opmaj: String = ""
    var status: Boolean = true
}
