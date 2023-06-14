package com.reeadigital.movieApp.data.datasource.remote.movie.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class MovieDetailDTO (
     val Title: String?,
     val Year: String?,
     val Rated: String?,
     val Released: String?,
     val Runtime: String?,
     val Genre: String?,
     val Director: String?,
     val Writer: String?,
    val Actors: String?,
    val Plot: String?,
     val Language: String?,
     val Country: String?,
     val Poster: String?,
    val Awards: String?,
    val Ratings: List<RatingDTO>?,
    @SerialName("imdbRating") val IMDB_Rating: String?,
    @SerialName("imdbVotes") val IMDB_Votes: String?,
    @SerialName("imdbID") val  IMDB_ID: String?,
     val Type: String?,
    val DVD: String?,
    val BoxOffice: String?,
    val Production: String?,
    val Website: String?,
    val Response: String?,
)
