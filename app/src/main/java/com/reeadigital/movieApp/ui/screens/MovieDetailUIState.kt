package com.reeadigital.movieapp.ui.screens

interface MovieDetailUIState {
    data class Success(val movieDetail: String) : MovieDetailUIState
    object Error : MovieDetailUIState
    object Loading : MovieDetailUIState

}