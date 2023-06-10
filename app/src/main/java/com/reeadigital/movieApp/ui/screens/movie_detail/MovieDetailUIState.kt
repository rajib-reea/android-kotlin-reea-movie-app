package com.reeadigital.movieapp.ui.screens.movie_detail

interface MovieDetailUIState {
    data class Success(val movieDetail: String) : MovieDetailUIState
    object Error : MovieDetailUIState
    object Loading : MovieDetailUIState

}