package com.reeadigital.movieapp.data.repository

import androidx.compose.runtime.MutableState
import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO

sealed class UIState<out T>{
    data class Success<out T>(val data: T) : UIState<T>()
    data class Error(val exception: Exception) : UIState<Nothing>()
    object Loading : UIState<Nothing>()
}