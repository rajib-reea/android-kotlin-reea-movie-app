package com.reeadigital.movieapp.data.datasource.remote.movie

import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieListDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
        @GET("/")
        suspend fun getMovieDetail(
                @Query("i") i : String,
                @Query("apikey") apiKey : String
        ): MovieDetailDTO

        @GET("/")
        suspend fun getMovieList(
                @Query("s") s: String,
                @Query("apikey") apiKey : String
        ): MovieListDTO
}


