package com.example.kinoposik.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.kinoposik.R
import com.example.kinoposik.domain.entities.Movie
import org.koin.java.KoinJavaComponent.inject

class PopularMoviesAdapter : RecyclerView.Adapter<PopularMoviesAdapter.MovieViewHolder>() {

    private val glide by inject<RequestManager>(RequestManager::class.java)

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    var movies: List<Movie>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        val ivMoviePoster = holder.itemView.findViewById<ImageView>(R.id.ivMoviePoster)
        val tvMovieTitle = holder.itemView.findViewById<TextView>(R.id.tvMovieTitle)

        holder.itemView.apply {
            glide
                .load(movie.imgUrl)
                .into(ivMoviePoster)
            tvMovieTitle.text = movie.title

            setOnClickListener {
                onMovieClickListener?.let { it(movie) }
            }
        }
    }

    override fun getItemCount(): Int = movies.size

    private var onMovieClickListener: ((Movie) -> Unit)? = null

    fun setOnMovieClickListener(listener: (Movie) -> Unit) {
        onMovieClickListener = listener
    }

}