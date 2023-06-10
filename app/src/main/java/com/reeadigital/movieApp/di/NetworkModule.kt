package com.reeadigital.movieapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.reeadigital.movieapp.config.Configuration
import com.reeadigital.movieapp.data.datasource.remote.movie.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Configuration.BASE_URL)
            //.addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(Json{
                isLenient=true
                ignoreUnknownKeys=true
            }.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }
}
