package com.reeadigital.movieapp.data.repository

import com.reeadigital.movieapp.data.datasource.remote.movie.MovieApiService
import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieListDTO
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
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