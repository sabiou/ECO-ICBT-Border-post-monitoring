package com.sim2g.icbt.di

import android.content.Context
import com.sim2g.icbt.data.persistence.AnneeDAO
import com.sim2g.icbt.data.persistence.AppDatabase
import com.sim2g.icbt.data.persistence.OperatorDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideEvaluationYearsDao(db: AppDatabase): AnneeDAO {
        return db.anneeDao()
    }

    @Provides
    fun provideEventsDao(db: AppDatabase): OperatorDAO {
        return db.operatorDao()
    }
}