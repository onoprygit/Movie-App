package com.onopry.movieapp.domain.models

import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import java.time.LocalDate

//todo override and equals/hashcode funcs

data class MovieDetails(
    val budget: Int,
    val genres: Array<GenreDto>,
    val id: Long,
    val overview: String,
    val poster: String,
    val moviePremiereDate: LocalDate,
    val revenue: Int,
    val runtime: Int,
    val tagline: String,
    val title: String,
    val userRating: Float,
    val certification: String,
    val cast: Array<ActorDto>
)
