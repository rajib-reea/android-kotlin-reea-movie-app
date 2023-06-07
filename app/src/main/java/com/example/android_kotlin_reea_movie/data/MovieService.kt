package com.example.android_kotlin_reea_movie.data;
import com.example.android_kotlin_reea_movie.data.dto.MovieListDTO
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

internal interface MovieService {
    @GET("")
    suspend fun  getMovies(): ApiResponse<MovieListDTO>
}
