package com.reeadigital.movieapp.data.repository

import com.reeadigital.movieapp.data.datasource.remote.MovieApi

class MovieRepository {
    companion object{
        suspend fun getMovieDetail(detailID: String): String {
            return MovieApi.retrofitService.getMovieDetail(detailID, "97edfc1b")
        }
    }
}