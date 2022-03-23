package com.sim2g.icbt.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sim2g.icbt.data.model.IOV

/**
 * Created by Farouk Sabiou on 3/21/22.
 */

@Dao
interface IovDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllIov(iov: List<IOV>)

    @Query("SELECT * FROM iov")
    suspend fun getAllIovList(): List<IOV>

    @Query("SELECT * FROM iov WHERE status = :status")
    suspend fun getAllInactiveIov(status: Boolean): List<IOV>
}