package com.sim2g.icbt.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
data class YearOfEvalResponse(
    val results: List<Result>
) {
    data class Result(
        @SerializedName("annee")
        val annee: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("datedebut")
        val dateDebut: String,
        @SerializedName("datefin")
        val dateFin: String,
        @SerializedName("status")
        val status: Boolean
    )
}