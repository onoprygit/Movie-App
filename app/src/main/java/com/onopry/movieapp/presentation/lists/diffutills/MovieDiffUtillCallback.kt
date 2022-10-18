package com.onopry.movieapp.presentation.lists.diffutills

import androidx.recyclerview.widget.DiffUtil
import com.onopry.movieapp.data.models.movie.preview.MoviePreviewItemResponseBody

class MovieDiffUtillCallback(
    private val oldMoviesList: List<MoviePreviewItemResponseBody>,
    private val newMoviesList: List<MoviePreviewItemResponseBody>
): DiffUtil.Callback() {
    override fun getOldListSize() = oldMoviesList.size

    override fun getNewListSize() = newMoviesList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldMoviesList[oldItemPosition].id == newMoviesList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldList = oldMoviesList[oldItemPosition]
        val newList = newMoviesList[newItemPosition]
        return oldList.originalTitle == newList.originalTitle
                && oldList.imagePath == newList.imagePath
                && oldList.description == newList.description
                && oldList.rating == newList.rating
                && oldList.releaseDate == newList.releaseDate
    }
}