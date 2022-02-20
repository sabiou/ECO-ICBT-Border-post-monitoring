package com.sim2g.icbt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "evaluation_years")
data class Annee(
    @PrimaryKey
    var id: String,
    var annee: String,
    var datedebut: String,
    var datefin: String,
    var status: Boolean = true
)
