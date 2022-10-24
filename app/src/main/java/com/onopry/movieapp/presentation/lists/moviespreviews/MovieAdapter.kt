package com.onopry.movieapp.presentation.lists.moviespreviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onopry.movieapp.R
import com.onopry.movieapp.data.models.movie.preview.MoviePreviewItemResponseBody
import com.onopry.movieapp.databinding.ItemMovieListBinding
import com.onopry.movieapp.domain.models.MoviePreview
import com.onopry.movieapp.presentation.lists.moviespreviews.MovieDiffUtillCallback

typealias OnRecyclerViewItemClickListener = (movieId: Long) -> Unit

class MovieAdapter(
    private val clickListener: OnRecyclerViewItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies = mutableListOf<MoviePreview>()

    fun setData(movies: List<MoviePreview>) {
        val diffUtillCallback = MovieDiffUtillCallback(this.movies, movies)
        val diffMovies = DiffUtil.calculateDiff(diffUtillCallback)
        this.movies = movies.toMutableList()
        diffMovies.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    inner class MovieViewHolder(val binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MoviePreview) {
            itemView.setOnClickListener{ clickListener.invoke(movie.id) }
            
            with(binding) {
                movieTitle.text = movie.originalTitle
                movieDescription.text = movie.description
                movieDuration.text = movie.releaseDate.toString()
                movieRating.text = movie.rating.toString()

//                movieImg.setImageResource(R.drawable.actor_photo_debug)
//                "poster_path": "/l8WZDmjJCxOhGToTlhO6l9YAytr.jpg",

                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${movie.imagePath}")
                    .placeholder(R.drawable.poster_placeholder)
                    .into(movieImg)

            }
        }

    }
}