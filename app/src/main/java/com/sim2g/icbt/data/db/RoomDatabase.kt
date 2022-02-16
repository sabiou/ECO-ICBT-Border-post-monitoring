package com.sim2g.icbt.data.db

import com.sim2g.icbt.data.model.Annee
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
class RoomDatabase @Inject constructor(
    private val yearsEvalDao: YearsEvalDao,
    private val cacheDatabase: CacheDatabase) : AppDatabase {

    override fun getYearsOfEvaluation(): Flow<List<Annee>> = yearsEvalDao.getYearsOfEvaluation().distinctUntilChanged()
    override suspend fun insertYearsData(annee: List<Annee>) {
        // later refactor using withTransaction
        yearsEvalDao.deleteAll(annee)
        yearsEvalDao.insertAll(annee)
    }
}