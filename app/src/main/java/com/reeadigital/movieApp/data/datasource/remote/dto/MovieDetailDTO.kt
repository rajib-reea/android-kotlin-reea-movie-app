package com.reeadigital.movieApp.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName
import com.reeadigital.movieApp.data.datasource.remote.NetworkResponse

 data class MovieDetailDTO(

    @SerializedName("Title")  val title: String,
    @SerializedName("Year")  val year: String,
    @SerializedName("Rated") val rated: String,
    @SerializedName("Released") val released: String,
    @SerializedName("Runtime") val runtime: String,
    @SerializedName("Genre") val genre: String,
    @SerializedName("Director") val director: String,
    @SerializedName("Writer") val writer: String,
    @SerializedName("Actors") val actors: String,
    @SerializedName("Plot") val plot: String,
    @SerializedName("Language") val language: String,
    @SerializedName("Country") val country: String,
    @SerializedName("Poster") val poster: String,
    @SerializedName("Ratings") val ratings: List<RatingDTO>,
    @SerializedName("Source") val meta_score: String,
    @SerializedName("imdbRating") val imdb_rating: String,
    @SerializedName("imdbVotes") val imdb_votes: String,
    @SerializedName("imdbID") val imdb_id: String,
    @SerializedName("Type") val type: String,
    @SerializedName("DVD") val dvd: String,
    @SerializedName("BoxOffice") val box_office: String,
    @SerializedName("Production") val production: String,
    @SerializedName("Website") val website: String,
    @SerializedName("Response") val response: String,
): NetworkResponse