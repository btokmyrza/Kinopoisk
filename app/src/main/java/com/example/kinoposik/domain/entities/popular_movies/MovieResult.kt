package com.example.kinoposik.domain.entities.popular_movies

import com.example.kinoposik.common.Constants.MOVIE_POSTER_BASE_URL
import com.example.kinoposik.presentation.models.Movie
import com.google.gson.annotations.SerializedName

data class MovieResult(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)

fun MovieResult.toMovie(): Movie {
    return Movie(
        tmdbId = id,
        title = title,
        imgUrl = MOVIE_POSTER_BASE_URL + posterPath
    )
}