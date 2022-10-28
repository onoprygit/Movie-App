package com.onopry.movieapp.presentation.lists.genres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.databinding.ItemGenreBinding

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.GenreViewHolder>() {

    private val genreList = arrayListOf<GenreDto>()

    fun setGenreList(list: Array<GenreDto>) {
        genreList.clear()
        genreList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val binding = ItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(genreList[position])
    }

    override fun getItemCount() = genreList.size

    class GenreViewHolder(val bindind: ItemGenreBinding) :
        RecyclerView.ViewHolder(bindind.root) {
        fun bind(genre: GenreDto) {
            bindind.genreName.text = genre.name
        }
    }
}