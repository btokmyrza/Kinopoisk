package com.example.kinoposik.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.RequestManager
import com.example.kinoposik.R
import com.example.kinoposik.common.Constants
import com.example.kinoposik.presentation.main.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.java.KoinJavaComponent.inject

class MovieDetailsBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private val mainViewModel by viewModel<MainViewModel>()
    private val glide by inject<RequestManager>(RequestManager::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_movie_details_bottom_sheet_dialog,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivMoviePoster = view.findViewById<ImageView>(R.id.iv_movie_poster)
        val tvMovieTitle = view.findViewById<TextView>(R.id.tv_movie_title)
        val tvMovieDescription = view.findViewById<TextView>(R.id.tv_movie_description)

        val movieId = arguments?.getInt("Movie") ?: 0
        mainViewModel.loadMovieDetails(movieId)
        mainViewModel.movieDetails.observe(this) { movieDetails ->
            glide
                .load(Constants.POSTER_BASE_URL + movieDetails.posterPath)
                .into(ivMoviePoster)
            tvMovieTitle.text = movieDetails.title
            tvMovieDescription.text = movieDetails.overview
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MovieDetailsBottomSheetDialogFragment()
    }
}