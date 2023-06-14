package com.reeadigital.movieApp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "movie_lists")
data class MovieList(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val Title: String?,
    @ColumnInfo(name = "year") val Year: String?,
    @ColumnInfo(name = "imdb_id")  val IMDB_ID: String?,
    @ColumnInfo(name = "type") val Type: String?,
    @ColumnInfo(name = "poster")  val Poster: String?,
    @ColumnInfo(name = "is_active") val IsActive: Boolean,
    val created: Timestamp,
    val modified: Timestamp,
)
