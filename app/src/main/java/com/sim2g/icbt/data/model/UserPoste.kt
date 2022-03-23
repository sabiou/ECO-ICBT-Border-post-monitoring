package com.sim2g.icbt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_poste")
data class UserPoste (
    @PrimaryKey
    var id: String,
    var codeopper: String,
    var idposte: String,
    var status: String
)