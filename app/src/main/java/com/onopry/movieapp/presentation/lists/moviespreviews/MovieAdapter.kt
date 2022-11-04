package com.onopry.movieapp.presentation.lists.moviespreviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onopry.movieapp.BuildConfig
import com.onopry.movieapp.R
import com.onopry.movieapp.common.logError
import com.onopry.movieapp.databinding.ItemMovieListBinding
import com.onopry.movieapp.domain.models.MoviePreview

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
            itemView.setOnClickListener { clickListener.invoke(movie.id) }

            with(binding) {
                movieTitle.text = movie.originalTitle
                movieDescription.text = movie.description
                movieDuration.text = movie.releaseDate
                movieRating.text = movie.rating.toString()

                Glide.with(itemView.context)
                    .load(BuildConfig.POSTER_URL + movie.imagePath)
                    .placeholder(R.drawable.poster_placeholder)
                    .into(movieImg)

            }
        }
    }
}

class MoviePagingAdapter(private val clickListener: OnRecyclerViewItemClickListener) :
    PagingDataAdapter<MoviePreview, MoviePagingAdapter.PagingMovieViewHolder>(
        diffCallback = PagingMoviePreviewDiffUtilCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingMovieViewHolder {
        val binding =
            ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagingMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagingMovieViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        loadStateFlow
    }

    inner class PagingMovieViewHolder(private val binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MoviePreview) {
            itemView.setOnClickListener { clickListener.invoke(movie.id) }

            logError("Movie item = $movie")

            with(binding) {
                movieTitle.text = movie.originalTitle
                movieDescription.text = movie.description
                movieDuration.text = movie.releaseDate
                movieRating.text = movie.rating.toString()

                Glide.with(itemView.context)
                    .load(BuildConfig.POSTER_URL + movie.imagePath)
                    .placeholder(R.drawable.poster_placeholder)
                    .into(movieImg)

            }
        }
    }
}

class PagingMoviePreviewDiffUtilCallback : DiffUtil.ItemCallback<MoviePreview>() {
    override fun areItemsTheSame(oldItem: MoviePreview, newItem: MoviePreview) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MoviePreview, newItem: MoviePreview) =
        oldItem.originalTitle == newItem.originalTitle
                && oldItem.imagePath == newItem.imagePath
                && oldItem.description == newItem.description
                && oldItem.rating == newItem.rating
                && oldItem.releaseDate == newItem.releaseDate
}