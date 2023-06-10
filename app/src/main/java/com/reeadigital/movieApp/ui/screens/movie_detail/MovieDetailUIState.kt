package com.reeadigital.movieapp.ui.screens.movie_detail

import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO

interface MovieDetailUIState {
    data class Success(val movieDetail: MovieDetailDTO) : MovieDetailUIState
    object Error : MovieDetailUIState
    object Loading : MovieDetailUIState

}