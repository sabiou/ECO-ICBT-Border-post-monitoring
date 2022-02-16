package com.sim2g.icbt.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sim2g.icbt.data.db.CacheDatabase
import com.sim2g.icbt.data.db.YearsEvalDao
import com.sim2g.icbt.data.repository.Repository
import com.sim2g.icbt.data.repository.RepositoryImpl
import com.sim2g.icbt.network.Services
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Farouk Sabiou on 2/16/22.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun roomDatabase(@ApplicationContext context: Context): RoomDatabase {
        return Room
            .databaseBuilder(context, CacheDatabase::class.java, "sim2g.db")
            .fallbackToDestructiveMigration()
            .build()
    }

//    @Singleton
//    @Provides
//    fun provideYearsOfEvalDao(cacheDatabase: CacheDatabase): YearsEvalDao = cacheDatabase.yearsEvalDao()

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun provideApiServices(gson: Gson): Services {
        return Retrofit.Builder()
            .baseUrl("http://monitoringtls-bakend.net/sim2g/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Services::class.java)
    }
}