package com.reeadigital.movieApp.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reeadigital.movieApp.data.datasource.local.entity.Movie
import com.reeadigital.movieApp.data.datasource.local.entity.MovieDetail
import com.reeadigital.movieApp.data.datasource.local.entity.Rating

@Database(entities = [Movie::class, MovieDetail::class, Rating::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    companion object{
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    MovieDatabase::class.java,
                    "movie_database")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}