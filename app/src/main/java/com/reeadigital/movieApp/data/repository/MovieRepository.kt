package com.reeadigital.movieapp.data.repository

//import com.reeadigital.movieapp.data.datasource.remote.MovieApi
import com.reeadigital.movieapp.data.datasource.remote.movie.MovieApiService
import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class MovieRepository @Inject constructor(
    private val movieApi: MovieApiService
    ){
        suspend fun getMovieDetail(detailID: String): MovieDetailDTO{

            return movieApi.getMovieDetail(detailID, "97edfc1b")
        }

    suspend fun getMovieList(searchKey: String): Flow<UIState<MovieDetailDTO>> =flow{
        emit(UIState.Loading)
        try {
            val movieDetail = movieApi.getMovieDetail(searchKey, "97edfc1b")
            emit(UIState.Success(movieDetail))

        } catch (e: Exception) {
            emit(UIState.Error(e))
        }
    }

//    suspend fun getMovieList(searchKey: String): Flow<List<MovieDetailDTO>> = flow {
//        val searchResult = movieApi.getMovieList(searchKey, "97edfc1b")
//        emit(searchResult)
//    }
}