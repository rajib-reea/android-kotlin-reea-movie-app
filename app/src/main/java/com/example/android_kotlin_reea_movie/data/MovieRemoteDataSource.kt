package com.example.android_kotlin_reea_movie.data;

import retrofit2.Response
import timber.log.Timber
import java.lang.Exception

internal sealed class MovieRemoteDataSource<T>(val data:  T?=null, val message:String?=null) {
    class Loading<T>: MovieRemoteDataSource<T>()
    class Success<T>(data: T?): MovieRemoteDataSource<T>(data=data)
    class Failure<T>(data: T?, message: String?) : MovieRemoteDataSource<T>(data=data, message=message)

    companion object{
        suspend fun <T>  getMovies(fn: suspend ()->Response<T>): MovieRemoteDataSource<T>{
             try {
                val response=fn();
                val body=response.body()
                if (response.isSuccessful) {
                    return Success<T>(data = body)
                }
            }catch (e: Exception){
                Timber.e("Request Failed and the Error Message: $e")
                return Failure<T>(data=null, message="Error happened.")
            }

        return TODO("Provide the return value")
       }
    }
}
