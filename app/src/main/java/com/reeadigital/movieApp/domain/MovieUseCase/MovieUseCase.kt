package com.reeadigital.movieapp.domain.MovieUseCase

import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieListDTO
import com.reeadigital.movieapp.data.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

//hilt gives an error when using coroutine dispatcher.
//need to look into detail.

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
   // private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend fun getMovieDetail(detailID: String): Flow<MovieDetailDTO> =flow{
        //withContext(defaultDispatcher){
            val  movieDetail=movieRepository.getMovieDetail(detailID)
            emit(movieDetail)
        //}
    }

    suspend fun getMovieList(searchKey: String): Flow<MovieListDTO> =flow{
        val  movieList=movieRepository.getMovieList(searchKey)
        emit(movieList)
    }
}