package com.sim2g.icbt.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sim2g.icbt.data.model.Annee

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
@Dao
interface AnneeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvaluationYearsList(years: List<Annee>)

    @Query("SELECT * FROM evaluation_years WHERE id = :id")
    suspend fun getEvaluationYear(id: String): Annee

    @Query("SELECT * FROM evaluation_years")
    suspend fun getEvaluationYearsList(): List<Annee>
}