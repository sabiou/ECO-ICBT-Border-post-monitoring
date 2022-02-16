package com.sim2g.icbt.data.db

import com.sim2g.icbt.data.model.Annee
import kotlinx.coroutines.flow.Flow

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
interface AppDatabase {
    fun getYearsOfEvaluation(): Flow<List<Annee>>
    suspend fun insertYearsData(annee: List<Annee>)
}