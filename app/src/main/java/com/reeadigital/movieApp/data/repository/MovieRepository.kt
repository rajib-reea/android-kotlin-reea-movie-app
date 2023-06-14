package com.reeadigital.movieApp.data.repository

import com.reeadigital.movieApp.MainApplication
import com.reeadigital.movieApp.data.datasource.local.MovieDatabase
import com.reeadigital.movieApp.data.datasource.local.entity.Movie
import com.reeadigital.movieApp.data.datasource.remote.movie.MovieApiService
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDTO
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieListDTO
import java.time.LocalDateTime
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApiService
    ){
        private fun convertToEntity(movieDTO: MovieDTO): Movie {
            return Movie(
                IMDB_ID = movieDTO.IMDB_ID,
                Title = movieDTO.Title,
                Type = movieDTO.Type,
                Year = movieDTO.Year,
                Poster = movieDTO.Poster,
                IsActive = "true",
                created = LocalDateTime.now().toString(),
                modified = LocalDateTime.now().toString()
            )
        }
        suspend fun getMovieDetail(detailID: String): MovieDetailDTO{
            //always get from the database
            return movieApi.getMovieDetail(detailID, "97edfc1b")
        }


    suspend fun getMovieList(searchKey: String): MovieListDTO {
        // val movieInstance=MovieDatabase.getDatabase(MainApplication())
        val movieList= movieApi.getMovieList(searchKey, "97edfc1b")
        val  movies=movieList.Search

        for (movieDTO in movies!!)  {
            //need to convert DTO object to ENTITY object
            val movie=convertToEntity(movieDTO)
           // movieInstance.movieDao().insertMovie(movie)
        }
        return movieList;
    }
}