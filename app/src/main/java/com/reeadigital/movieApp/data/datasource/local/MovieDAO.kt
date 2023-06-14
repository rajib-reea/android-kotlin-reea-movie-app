package com.reeadigital.movieApp.data.datasource.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.reeadigital.movieApp.data.datasource.local.entity.Movie
import com.reeadigital.movieApp.data.datasource.local.entity.MovieDetail
import com.reeadigital.movieApp.data.datasource.local.entity.Rating


interface MovieDAO {
    //insert
    @Insert
    fun insertMovie(movie: Movie)
    @Insert
    fun insertMovieDetail( movieDetail: MovieDetail)
    @Insert
    fun insertRating( rating:Rating)
    //delete
    @Delete
    fun deleteMovie(movie: Movie)
    @Delete
    fun deleteMovieDetail( movieDetail:MovieDetail)
    @Delete
    fun deleteRating( rating:Rating)
    //query
    @Query("SELECT * FROM movie_details  ORDER BY created ASC")
    fun getAll(): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  genre=:genre ORDER BY created ASC")
    fun getByGenre(genre: String): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  country=:country ORDER BY created ASC")
    fun getByCountry(country:String): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  language=:language ORDER BY created ASC")
    fun getByLanguage(language: String): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  year=:year ORDER BY created ASC")
    fun getByYear(year: String): List<MovieDetail>
    @Query("SELECT * FROM movie_details WHERE  director=:director ORDER BY created ASC")
    fun getByDirector(director:String): List<MovieDetail>
}