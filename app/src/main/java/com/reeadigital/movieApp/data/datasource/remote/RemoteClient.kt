package com.reeadigital.movieapp.data.datasource.remote

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class RemoteClient {
    companion object {
        private const val BASE_URL ="https://www.omdbapi.com"

        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}