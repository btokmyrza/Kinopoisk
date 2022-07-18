package com.example.kinoposik.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinoposik.common.Constants.API_KEY
import com.example.kinoposik.data.remote.dto.movie_details.MovieDetails
import com.example.kinoposik.data.repository.MovieRepositoryImpl
import com.example.kinoposik.data.remote.dto.popular_movies.toMovie
import com.example.kinoposik.domain.entities.Movie
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MovieRepositoryImpl
) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>> = _popularMovies

    private val _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails: LiveData<MovieDetails> = _movieDetails

    init {
        loadPopularMovies()
    }

    private fun loadPopularMovies() {
        viewModelScope.launch {
            _popularMovies.postValue(repository.getPopularMovies(API_KEY).results.map { it.toMovie() })
        }
    }

    fun loadMovieDetails(id: Int) {
        viewModelScope.launch {
            val movieDetails = repository.getMovieDetails(id, API_KEY)
            _movieDetails.postValue(movieDetails)
        }
    }

}