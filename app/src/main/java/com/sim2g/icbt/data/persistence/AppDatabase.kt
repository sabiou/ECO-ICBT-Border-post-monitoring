package com.sim2g.icbt.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sim2g.icbt.data.model.Annee
import com.sim2g.icbt.data.model.BorderPost
import com.sim2g.icbt.data.model.IOV
import com.sim2g.icbt.data.model.Operateur

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
@Database(
    entities = [Annee::class, Operateur::class, IOV::class, BorderPost::class],
    version = 15, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun anneeDao(): AnneeDAO
    abstract fun operatorDao(): OperatorDAO
    abstract fun iovDao(): IovDAO
    abstract fun borderPostDao(): BorderPostDAO

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "sim2g-eco-db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}