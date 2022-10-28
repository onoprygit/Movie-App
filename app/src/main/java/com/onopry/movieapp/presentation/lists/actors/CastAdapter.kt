package com.onopry.movieapp.presentation.lists.actors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onopry.movieapp.R
import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.databinding.ItemActorBinding

/*

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.GenreViewHolder>() {


}

*/

class CastAdapter : RecyclerView.Adapter<CastAdapter.ActorViewHolder>() {
    private val actorsList = arrayListOf<ActorDto>()

    fun setActorsList(list: Array<ActorDto>) {
        actorsList.clear()
        actorsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val binding = ItemActorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actorsList[position])
    }

    override fun getItemCount() = actorsList.size

    class ActorViewHolder(private val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: ActorDto) {
            binding.actorName.text = actor.name

            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500${actor.imageUrl}")
                .placeholder(R.drawable.poster_placeholder)
                .into(binding.actorImage)
        }
    }
}