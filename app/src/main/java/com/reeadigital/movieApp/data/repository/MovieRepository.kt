package com.reeadigital.movieapp.data.repository

//import com.reeadigital.movieapp.data.datasource.remote.MovieApi
import com.reeadigital.movieapp.data.datasource.remote.movie.MovieApiService
import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MovieRepository @Inject constructor(
    private val movieApi: MovieApiService
    ){
   // companion object{
        suspend fun getMovieDetail(detailID: String): MovieDetailDTO {
           return movieApi.getMovieDetail(detailID, "97edfc1b")
        //}
    }
}