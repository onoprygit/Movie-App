package com.onopry.movieapp.data.models.movie

import java.util.*

data class MoviesDto(
    val id: Int,
    val title: String,
    val description: String,
    val rating: Int,
    val ageLimit: Int,
    val imageUrl: String
)
