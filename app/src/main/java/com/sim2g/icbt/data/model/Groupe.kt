package com.sim2g.icbt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groupe")
data class Groupe(
    @PrimaryKey
    var idgroupe: String,
    var groupe: String
)
