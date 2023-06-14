package com.reeadigital.movieApp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_details")
data class MovieDetail(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val Title: String?,
    @ColumnInfo(name = "year") val Year: String?,
    @ColumnInfo(name = "rated") val Rated: String?,
    @ColumnInfo(name = "released") val Released: String?,
    @ColumnInfo(name = "runtime") val Runtime: String?,
    @ColumnInfo(name = "genre") val Genre: String?,
    @ColumnInfo(name = "director") val Director: String?,
    @ColumnInfo(name = "writer") val Writer: String?,
    @ColumnInfo(name = "actors") val Actors: String?,
    @ColumnInfo(name = "plot") val Plot: String?,
    @ColumnInfo(name = "language") val Language: String?,
    @ColumnInfo(name = "country") val Country: String?,
    @ColumnInfo(name = "poster") val Poster: String?,
    @ColumnInfo(name = "awards") val Awards: String?,
    @ColumnInfo(name = "imdb_rating") val IMDB_Rating: String?,
    @ColumnInfo(name = "imdb_votes") val IMDB_Votes: String?,
    @ColumnInfo(name = "imdb_id") val  IMDB_ID: String?,
    @ColumnInfo(name = "type") val Type: String?,
    @ColumnInfo(name = "dvd") val DVD: String?,
    @ColumnInfo(name = "box_office") val BoxOffice: String?,
    @ColumnInfo(name = "production") val Production: String?,
    @ColumnInfo(name = "website") val Website: String?,
    @ColumnInfo(name = "response") val Response: String?,
    @ColumnInfo(name = "is_active") val IsActive: Boolean,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP") val created: String,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP") val modified: String,
)
