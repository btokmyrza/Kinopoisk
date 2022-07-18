package com.example.kinoposik.domain.repository

import com.example.kinoposik.common.Constants.API_KEY
import com.example.kinoposik.domain.entities.movie_details.MovieDetails
import com.example.kinoposik.domain.entities.popular_movies.PopularMovies

interface MovieRepository {

    suspend fun getPopularMovies(apiKey: String = API_KEY): PopularMovies

    suspend fun getMovieDetails(movieId: Int, apiKey: String = API_KEY): MovieDetails

}