package com.sim2g.icbt.data.repository

import com.sim2g.icbt.data.db.AppDatabase
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.mappers.YearsOfEvalResponseToYearsOfEval
import com.sim2g.icbt.network.Services

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Farouk Sabiou on 2/16/22.
 */

class RepositoryImpl @Inject constructor(
    private val apiServices: Services,
    private val appDatabase: AppDatabase,
    private val yearsOfEvalResponseToYearsOfEval: YearsOfEvalResponseToYearsOfEval
    ): Repository {
    override fun getYearsOfEvaluation(): Flow<List<Annee>> = appDatabase.getYearsOfEvaluation()
    override suspend fun refreshData() {

    }
}