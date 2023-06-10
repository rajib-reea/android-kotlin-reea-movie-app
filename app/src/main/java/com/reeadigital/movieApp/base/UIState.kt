package com.reeadigital.movieapp.base

sealed class UIState<out T>{
    data class Success<out T>(val data: T) : UIState<T>()
    data class Error(val exception: Exception) : UIState<Nothing>()
    object Loading : UIState<Nothing>()
}