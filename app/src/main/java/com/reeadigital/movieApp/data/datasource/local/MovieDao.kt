package com.reeadigital.movieApp.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.reeadigital.movieApp.data.datasource.local.entity.Movie
import com.reeadigital.movieApp.data.datasource.local.entity.MovieDetail
import com.reeadigital.movieApp.data.datasource.local.entity.Rating

@Dao
interface MovieDao {
    //insert
    @Insert
    suspend fun insertMovie(vararg movie: Movie)
    @Insert
    suspend fun insertMovieDetail(vararg movieDetail: MovieDetail)
    @Insert
    suspend fun insertRating(vararg rating: Rating)
    //delete
    @Delete
    suspend fun deleteMovie(movie: Movie)
    @Delete
    suspend fun deleteMovieDetail( movieDetail:MovieDetail)
    @Delete
    suspend fun deleteRating( rating:Rating)
    //query
    @Query("SELECT * FROM movie_details  ORDER BY created ASC")
    suspend fun getAll(): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  genre=:genre ORDER BY created ASC")
    suspend fun getByGenre(genre: String): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  country=:country ORDER BY created ASC")
    suspend fun getByCountry(country:String): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  language=:language ORDER BY created ASC")
    suspend fun getByLanguage(language: String): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  year=:year ORDER BY created ASC")
    suspend fun getByYear(year: String): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  director=:director ORDER BY created ASC")
    suspend fun getByDirector(director:String): List<MovieDetail>
}