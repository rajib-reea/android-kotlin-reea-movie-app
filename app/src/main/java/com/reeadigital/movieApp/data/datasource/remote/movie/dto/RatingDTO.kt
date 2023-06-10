package com.reeadigital.movieapp.data.datasource.remote.movie.dto

import kotlinx.serialization.Serializable

@Serializable
data class RatingDTO(
    val Source:String?,
    val Value:String?,
)
