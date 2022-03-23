package com.sim2g.icbt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "iov")
data class IOV(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var idIov: String?,
    var cible: String,
    var dateCre: String?,
    var dateMaj: String?,
    var description: String,
    var libelle: String,
    var libellefr: String,
    var opcre: String,
    var opmaj: String,
    var periodicite: String,
    var status: Boolean,
    var type: String
)
