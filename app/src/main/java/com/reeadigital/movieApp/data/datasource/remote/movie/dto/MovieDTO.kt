package com.reeadigital.movieApp.data.datasource.remote.movie.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class MovieDTO(
    val Title: String?,
    val Year: String?,
    @SerialName("imdbID") val IMDB_ID: String?,
    val Type: String?,
    val Poster: String?,
)
