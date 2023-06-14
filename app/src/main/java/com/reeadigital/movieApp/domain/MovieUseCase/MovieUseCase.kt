package com.reeadigital.movieApp.domain.MovieUseCase

import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDTO
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieListDTO
import com.reeadigital.movieApp.data.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

//hilt gives an error when using coroutine dispatcher.
//need to look into detail.

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
   // private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend fun getMovieDetail(detailID: String): Flow<MovieDetailDTO> =flow{
        val  movieDetail=movieRepository.getMovieDetail(detailID)
        emit(movieDetail)
    }.flowOn(Dispatchers.Default)

    suspend fun getMovieList(searchKey: String): Flow<List<MovieDTO>?> =flow{
        val  movieListResult=movieRepository.getMovieList(searchKey)
        val movieList=movieListResult.Search
        emit(movieList)
    }.flowOn(Dispatchers.Default)
}