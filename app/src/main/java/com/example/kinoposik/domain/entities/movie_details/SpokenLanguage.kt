package com.example.kinoposik.domain.entities.movie_details

import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
    @SerializedName("english_name")
    val languageEnglishName: String,
    @SerializedName("iso_639_1")
    val isoLanguageCode: String,
    val name: String
)