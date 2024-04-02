package com.example.mycleanproject.di

import com.example.mycleanproject.core.utils.Constant.BASE_URL
import com.example.mycleanproject.data.FreeGameApiService
import com.example.mycleanproject.data.repository.FreeGamesRepositoryImpl
import com.example.mycleanproject.domain.repositories.FreeGamesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient {
        val logginInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient
            .Builder()
            .addInterceptor(Interceptor { chain ->
                val builder = chain.request().newBuilder()
                HttpLoggingInterceptor.Level.BODY
             /*   builder.header(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxYzkxN2ZjMWIxMTgxNTY4NDJiMzYyN2ZmODEwY2Q4YyIsInN1YiI6IjVhYTAxZWQzMGUwYTI2MzI3YTAxMGEzMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.W5PptCGyk0S9lHOADzCZR2dD1ZrKHspNlSLrmvsexGE"
                )*/
                return@Interceptor chain.proceed(builder.build())
            })
            .addInterceptor(logginInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideClient())
            .build()
    }

    @Singleton
    @Provides
    fun freeGameApi(retrofit: Retrofit): FreeGameApiService {
        return retrofit.create(FreeGameApiService::class.java)
    }

    @Singleton
    @Provides
    fun freeGameRepository(freeGameApiService: FreeGameApiService): FreeGamesRepository {
        return FreeGamesRepositoryImpl(freeGameApiService)
    }
}