package com.reeadigital.movieApp.di

import com.reeadigital.movieApp.data.datasource.remote.movie.MovieApiService
import com.reeadigital.movieApp.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(movieApi: MovieApiService): MovieRepository = MovieRepository(movieApi)
}