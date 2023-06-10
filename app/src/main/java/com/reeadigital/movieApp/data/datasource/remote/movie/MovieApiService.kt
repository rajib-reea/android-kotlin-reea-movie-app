package com.reeadigital.movieapp.data.datasource.remote.movie

import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
        @GET("/")
        suspend fun getMovieDetail(
                @Query("i") i : String,
                @Query("apikey") apiKey : String
        ): MovieDetailDTO
}


