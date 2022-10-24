package com.onopry.movieapp.presentation.lists

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtillCallback<T>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    abstract override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean

    abstract override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
}