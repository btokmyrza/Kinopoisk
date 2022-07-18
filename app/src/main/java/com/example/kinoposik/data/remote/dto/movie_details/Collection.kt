package com.example.kinoposik.data.remote.dto.movie_details

import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("id")
    val collectionId: Int,
    @SerializedName("name")
    val collectionName: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    val backdropPath: String
)
