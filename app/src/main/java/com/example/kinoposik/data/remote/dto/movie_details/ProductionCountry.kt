package com.example.kinoposik.data.remote.dto.movie_details

import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val isoCountryCode: String,
    val name: String
)