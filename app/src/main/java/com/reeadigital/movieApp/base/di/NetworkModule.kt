package com.reeadigital.movieApp.base.di

import com.reeadigital.movieApp.data.datasource.remote.RequestInterceptor
import com.reeadigital.movieApp.data.datasource.remote.service.MovieService
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.MainScope
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    /*
    * the provideOkHttpClient gives us the opportunity to add different types of interceptors
    * */
    @Provides
    @Singleton
     fun provideOkHttpClient(): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        return OkHttpClient.Builder()
           // .addInterceptor(RequestInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
    }

    /*
    * the provideRetrofit gives us the opportunity to add baseURL and Serialization facility.
    * The known limitation is here we have added the baseURL as hard-coded.
    * */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://www.omdbapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create(MainScope()))
            .build()
    }

    /*
   * the provideMovieService gives us the opportunity to get  data using an interface..
   * */
    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService{
        return retrofit.create(MovieService::class.java)
    }
}