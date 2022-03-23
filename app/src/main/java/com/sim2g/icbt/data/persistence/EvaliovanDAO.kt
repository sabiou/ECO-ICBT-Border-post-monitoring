package com.sim2g.icbt.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sim2g.icbt.data.model.Evaliovan

/**
 * Created by Farouk Sabiou on 3/17/22.
 */
@Dao
interface EvaliovanDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEvaliovanList(evaliovan: List<Evaliovan>)

    @Query("SELECT * FROM evaliovan WHERE id = :id")
    suspend fun getEvaliovan(id: String): Evaliovan

    @Query("SELECT * FROM evaliovan")
    suspend fun getEvaliovanList(): List<Evaliovan>
}