package com.example.kinoposik.domain.repository

import com.example.kinoposik.common.Constants.API_KEY
import com.example.kinoposik.data.remote.dto.movie_details.MovieDetails
import com.example.kinoposik.data.remote.dto.popular_movies.PopularMovies

interface MovieRepository {

    suspend fun getPopularMovies(apiKey: String = API_KEY): PopularMovies

    suspend fun getMovieDetails(movieId: Int, apiKey: String = API_KEY): MovieDetails

}