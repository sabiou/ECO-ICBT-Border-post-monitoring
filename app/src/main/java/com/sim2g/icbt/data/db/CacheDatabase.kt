package com.sim2g.icbt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sim2g.icbt.data.model.Annee

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
@Database(
    entities = [
        Annee::class
    ], version = 1
)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun yearsEvalDao(): YearsEvalDao
}