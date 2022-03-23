package com.sim2g.icbt.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "operators")
@Parcelize
data class Operateur (
    @PrimaryKey
    var id: String,
    var datecre: String,
    var datemaj: String,
    var datenaissance: String,
    var fonction: String,
    var ident: String?,
    var idpfoc: String?,
    var idgroupe: String,
    var meloper: String,
    var nationalite: String,
    var nomoper: String,
    var numero: String,
    var opcre: String,
    var opmaj: String?,
    var password: String,
    var photo: String?,
    var sexe: String
) : Parcelable
