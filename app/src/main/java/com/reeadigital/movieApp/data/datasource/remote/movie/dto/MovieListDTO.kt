package com.reeadigital.movieApp.data.datasource.remote.movie.dto

import kotlinx.serialization.Serializable

@Serializable
data class MovieListDTO(
    val Search: List<MovieDTO>?
)
