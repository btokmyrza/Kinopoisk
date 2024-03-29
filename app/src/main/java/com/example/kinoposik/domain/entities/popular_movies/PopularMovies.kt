package com.example.kinoposik.domain.entities.popular_movies

data class PopularMovies(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)