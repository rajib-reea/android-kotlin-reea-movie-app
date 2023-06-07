package com.example.android_kotlin_reea_movie.data;
import com.example.android_kotlin_reea_movie.data.dto.MovieListDTO
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieService {
    @GET("/")
    suspend fun  getMovies(
        @Query("s") searchText:String,
        @Query("api_key") apiKey: String
    ): Response<MovieListDTO>
}
