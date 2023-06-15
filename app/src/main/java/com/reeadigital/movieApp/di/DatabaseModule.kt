package com.reeadigital.movieApp.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.reeadigital.movieApp.data.datasource.local.MovieDao
import com.reeadigital.movieApp.data.datasource.local.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  DatabaseModule {
    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        return databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "movie_db"
        )//.addMigrations(MIGRATION_1_2).build()
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }

}