package com.reeadigital.movieApp.data.datasource.remote.dto


import com.google.gson.annotations.SerializedName
import com.reeadigital.movieApp.data.datasource.remote.NetworkResponse

data  class RatingDTO(
    @SerializedName("Source")  val source:String,
    @SerializedName("Value")  val value:String
): NetworkResponse
