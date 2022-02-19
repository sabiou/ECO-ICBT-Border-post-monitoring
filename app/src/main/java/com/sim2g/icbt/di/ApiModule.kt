package com.sim2g.icbt.di

import com.sim2g.icbt.data.repository.YearsOfEvaluationRepository
import com.sim2g.icbt.network.Services
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Farouk Sabiou on 2/19/22.
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASE_URL = "http://monitoringtls-bakend.net/sim2g/api/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): Services = retrofit.create(Services::class.java)

    @Singleton
    @Provides
    fun providesYearOfEvaluationRepository(api: Services) = YearsOfEvaluationRepository(api)
}