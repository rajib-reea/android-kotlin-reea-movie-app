package com.reeadigital.movieapp.data.datasource.remote

object MovieApi {
    val retrofitService : MovieApiService by lazy {
        RemoteClient.retrofit.create(MovieApiService::class.java)
    }
}