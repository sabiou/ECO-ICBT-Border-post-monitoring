package com.sim2g.icbt.data.model

import androidx.room.Entity
import com.sim2g.icbt.data.db.BaseEntity

@Entity(tableName = "years_evaluation")
data class Annee(
    var annee: String,
    var datedebut: String,
    var datefin: String,
    var id: String,
    var status: Boolean
)
