package com.sim2g.icbt.di.module

import com.sim2g.icbt.data.db.AppDatabase
import com.sim2g.icbt.data.db.RoomDatabase
import com.sim2g.icbt.data.db.YearsEvalDao
import com.sim2g.icbt.data.repository.Repository
import com.sim2g.icbt.data.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Farouk Sabiou on 2/16/22.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {

//    @Singleton
//    @Binds
//    abstract fun provideRepository(impl: RepositoryImpl): Repository

//    @Binds
//    abstract fun provideAppDatabase(impl: RoomDatabase): AppDatabase

//    @Binds
//    abstract fun provideYearsOfEvalDao(impl: YearsEvalDao): YearsEvalDao
}