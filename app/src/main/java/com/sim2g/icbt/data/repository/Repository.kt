package com.sim2g.icbt.data.repository

import com.sim2g.icbt.data.model.Annee
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
interface Repository {

    fun getYearsOfEvaluation(): Flow<List<Annee>>

    suspend fun refreshData()
}