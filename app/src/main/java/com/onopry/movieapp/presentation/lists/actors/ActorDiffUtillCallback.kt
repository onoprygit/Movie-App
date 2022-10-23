package com.onopry.movieapp.presentation.lists.actors

import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.presentation.lists.BaseDiffUtillCallback

class ActorDiffUtillCallback(
    private val oldList: List<ActorDto>,
    private val newList: List<ActorDto>
) : BaseDiffUtillCallback<ActorDto>(oldList, newList) {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldListItem = oldList[oldItemPosition]
        val newListItem = newList[newItemPosition]
        return oldListItem.id == newListItem.id
                && oldListItem.name == newListItem.name
                && oldListItem.order == newListItem.order
                && oldListItem.character == newListItem.character
                && oldListItem.imageUrl == newListItem.imageUrl
    }
}