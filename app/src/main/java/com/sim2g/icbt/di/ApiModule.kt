package com.sim2g.icbt.di

import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import com.sim2g.icbt.data.persistence.*
import com.sim2g.icbt.data.repository.*
import com.sim2g.icbt.network.RequestInterceptor
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

val gson = GsonBuilder()
    .setDateFormat("yyyy-MM-dd'T'hh:mm:ssZ")
    .create()

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASE_URL = "http://monitoringtls-bakend.net/sim2g/api/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): Services = retrofit.create(Services::class.java)

    @Provides
    @Singleton
    fun providesYearOfEvaluationRepository(
        services: Services,
        anneeDAO: AnneeDAO): YearsOfEvaluationRepository {
        return YearsOfEvaluationRepository(services, anneeDAO)
    }

    @Provides
    @Singleton
    fun providesOperatorsRepository(services: Services, operatorDAO: OperatorDAO): OperatorsRepository {
        return OperatorsRepository(services, operatorDAO)
    }

    @Provides
    @Singleton
    fun providesEvaliovanRepository(services: Services, evaliovanDAO: EvaliovanDAO): EvaliovanRepository {
        return EvaliovanRepository(services, evaliovanDAO)
    }

    @Provides
    @Singleton
    fun providesIovRepository(services: Services, iovDAO: IovDAO): IovRepository {
        return IovRepository(services, iovDAO)
    }

    @Provides
    @Singleton
    fun providesBorderPostsRepository(services: Services, borderPostDAO: BorderPostDAO): BorderPostRepository {
        return BorderPostRepository(services, borderPostDAO)
    }

    @Provides
    @Singleton
    fun providesUserRepository(sharedPreferences: SharedPreferences): UserRepository {
        return UserRepository(sharedPreferences)
    }
}