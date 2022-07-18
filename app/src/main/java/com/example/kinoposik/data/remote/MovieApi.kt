package com.example.kinoposik.data.remote

import com.example.kinoposik.data.remote.dto.movie_details.MovieDetails
import com.example.kinoposik.data.remote.dto.popular_movies.PopularMovies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): PopularMovies

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): MovieDetails

}