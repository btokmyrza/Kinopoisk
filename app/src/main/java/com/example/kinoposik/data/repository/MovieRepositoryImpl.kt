package com.example.kinoposik.data.repository

import com.example.kinoposik.data.remote.MovieApi
import com.example.kinoposik.data.remote.dto.movie_details.MovieDetails
import com.example.kinoposik.data.remote.dto.popular_movies.PopularMovies
import com.example.kinoposik.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getPopularMovies(apiKey: String): PopularMovies {
        return api.getPopularMovies(apiKey)
    }

    override suspend fun getMovieDetails(movieId: Int, apiKey: String): MovieDetails {
        return api.getMovieDetails(movieId, apiKey)
    }

}