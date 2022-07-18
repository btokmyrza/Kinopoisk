package com.example.kinoposik.data.remote.dto.popular_movies

data class PopularMovies(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)