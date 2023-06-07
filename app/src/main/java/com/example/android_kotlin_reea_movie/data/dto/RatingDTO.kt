package com.example.android_kotlin_reea_movie.data.dto

import com.google.gson.annotations.SerializedName

internal class RatingDTO(
    @SerializedName("Source")  val source:String,
    @SerializedName("Value")  val value:String
    )
