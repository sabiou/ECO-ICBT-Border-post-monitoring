package com.sim2g.icbt.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sim2g.icbt.data.model.BorderPost
import com.sim2g.icbt.data.model.IOV

/**
 * Created by Farouk Sabiou on 3/22/22.
 */
@Dao
interface BorderPostDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBordersPosts(bordersPosts: List<BorderPost>)

    @Query("SELECT * FROM border_post")
    suspend fun getAllBorderPosts(): List<BorderPost>
}