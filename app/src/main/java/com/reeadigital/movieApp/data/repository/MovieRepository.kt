package com.reeadigital.movieApp.data.repository

import com.reeadigital.movieApp.data.datasource.remote.movie.MovieApiService
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieListDTO
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApiService
    ){
        suspend fun getMovieDetail(detailID: String): MovieDetailDTO{
            return movieApi.getMovieDetail(detailID, "97edfc1b")
        }

    suspend fun getMovieList(searchKey: String): MovieListDTO {
        return movieApi.getMovieList(searchKey, "97edfc1b")
    }
}