package com.sim2g.icbt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Farouk Sabiou on 3/20/22.
 */
@Entity(tableName = "border_post")
data class BorderPost(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val coordx: String,
    val coordy: String,
    val idpays: String,
    val linkposte: String?,
    val nomPays: String,
    val posteName: String,
    val posteid: String,
    val postejuxt: Int,
    val status: Boolean = true
)