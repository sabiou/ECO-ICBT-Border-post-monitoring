package com.sim2g.icbt.data.db

import androidx.room.*
import com.sim2g.icbt.data.model.Annee
import kotlinx.coroutines.flow.Flow

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
@Dao
interface YearsEvalDao {

    @Query("select * from years_evaluation")
    fun getYearsOfEvaluation(): Flow<List<Annee>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(annee: Annee)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(years: List<Annee>)

    @Update
    suspend fun update(annee: Annee)

    @Delete
    suspend fun delete(annee: Annee)

    @Delete
    suspend fun deleteAll(years: List<Annee>)
}