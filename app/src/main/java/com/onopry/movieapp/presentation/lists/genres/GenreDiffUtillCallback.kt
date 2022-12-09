package com.onopry.movieapp.presentation.lists.genres

import com.onopry.movieapp.data.models.remote.GenreDto
import com.onopry.movieapp.presentation.lists.BaseDiffUtillCallback

class GenreDiffUtillCallback(
    private val oldList: List<GenreDto>,
    private val newList: List<GenreDto>
) : BaseDiffUtillCallback<GenreDto>(oldList, newList) {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldListItem = oldList[oldItemPosition]
        val newListItem = newList[newItemPosition]
        return oldListItem.id == newListItem.id && oldListItem.name == newListItem.name
    }
}