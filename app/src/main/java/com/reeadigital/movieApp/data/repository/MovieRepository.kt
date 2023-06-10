package com.reeadigital.movieapp.data.repository

//import com.reeadigital.movieapp.data.datasource.remote.MovieApi
import com.reeadigital.movieapp.data.datasource.remote.MovieApiService
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MovieRepository @Inject constructor(
    private val movieApi: MovieApiService
    ){
   // companion object{
        suspend fun getMovieDetail(detailID: String): String {
           return movieApi.getMovieDetail(detailID, "97edfc1b")
        //}
    }
}