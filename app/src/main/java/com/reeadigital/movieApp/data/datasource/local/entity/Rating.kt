package com.reeadigital.movieApp.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ratings")
data class Rating(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "movie_detail_id") val MovieDetailID: Int,
    @ColumnInfo(name = "source") val Source:String?,
    @ColumnInfo(name = "value") val Value:String?,
    @ColumnInfo(name = "is_active") val IsActive: Boolean,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP") val created: String?,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP") val modified: String?,
)
