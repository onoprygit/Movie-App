package com.onopry.movieapp.presentation.lists.diffutills

import androidx.recyclerview.widget.DiffUtil
import com.onopry.movieapp.data.models.movie.MoviesDto
import com.onopry.movieapp.domain.models.MoviePreview

class MovieDiffUtillCallback(
    private val oldMoviesList: List<MoviePreview>,
    private val newMoviesList: List<MoviePreview>
): DiffUtil.Callback() {
    override fun getOldListSize() = oldMoviesList.size

    override fun getNewListSize() = newMoviesList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldMoviesList[oldItemPosition].id == newMoviesList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldList = oldMoviesList[oldItemPosition]
        val newList = newMoviesList[newItemPosition]
        return oldList.movieTitle == newList.movieTitle
                && oldList.imageUrl == newList.imageUrl
                && oldList.description == newList.description
                && oldList.rating == newList.rating
                && oldList.ageLimit == newList.ageLimit
    }
}