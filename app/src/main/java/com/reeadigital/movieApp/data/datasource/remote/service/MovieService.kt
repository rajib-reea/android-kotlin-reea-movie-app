package com.reeadigital.movieApp.data.datasource.remote.service

import com.reeadigital.movieApp.data.datasource.remote.dto.MovieDetailDTO
import com.reeadigital.movieApp.data.datasource.remote.dto.MovieListDTO
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface  MovieService {
    @GET("/")
    suspend fun getMovieList():ApiResponse<MovieListDTO>
    @GET("/")
    suspend fun getMovieDetail():ApiResponse<MovieDetailDTO>
}