package com.sim2g.icbt.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
interface EntityDao<T : BaseEntity<Any?>> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: List<T>)

    @Update
    suspend fun update(t: T)

    @Delete
    suspend fun delete(t: T)
}