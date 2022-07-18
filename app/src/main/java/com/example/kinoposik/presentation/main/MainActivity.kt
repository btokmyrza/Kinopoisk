package com.example.kinoposik.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinoposik.R
import com.example.kinoposik.presentation.MovieDetailsBottomSheetDialogFragment
import com.example.kinoposik.presentation.adapters.PopularMoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMovies = findViewById<RecyclerView>(R.id.rv_movies)
        val layoutManager = GridLayoutManager(this, 2)
        val popularMoviesAdapter = PopularMoviesAdapter()
        rvMovies.adapter = popularMoviesAdapter
        rvMovies.layoutManager = layoutManager

        mainViewModel.popularMovies.observe(this) { popularMovies ->
            popularMoviesAdapter.movies = popularMovies
        }

        popularMoviesAdapter.setOnMovieClickListener {
            val movieDetailsBottomSheetDialog = MovieDetailsBottomSheetDialogFragment.newInstance()
            val bundle = Bundle()
            bundle.putInt("Movie", it.tmdbId)
            movieDetailsBottomSheetDialog.arguments = bundle
            movieDetailsBottomSheetDialog.show(supportFragmentManager, null)
        }
    }
}