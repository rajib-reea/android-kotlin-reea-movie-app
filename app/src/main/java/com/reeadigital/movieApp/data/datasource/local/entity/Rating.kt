package com.reeadigital.movieApp.data.datasource.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
@Entity(tableName = "ratings")
data class Rating(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "movie_detail_id") val MovieDetailID: Int,
    @ColumnInfo(name = "source") val Source:String?,
    @ColumnInfo(name = "value") val Value:String?,
    @ColumnInfo(name = "is_active") val IsActive: Boolean,
    val created: Timestamp,
    val modified: Timestamp,
)
