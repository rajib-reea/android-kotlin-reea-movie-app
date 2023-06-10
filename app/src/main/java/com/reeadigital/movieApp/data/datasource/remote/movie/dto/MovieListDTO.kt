package com.reeadigital.movieapp.data.datasource.remote.movie.dto

import kotlinx.serialization.Serializable

@Serializable
data class MovieListDTO(
    val Source:List<MovieDetailDTO>?
)
