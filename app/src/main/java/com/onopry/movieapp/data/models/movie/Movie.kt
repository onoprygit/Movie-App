package com.onopry.movieapp.data.models.movie

import java.util.*

data class Movie(
    val id: UUID,
    val title: String,
    val description: String,
    val rateScore: Int,
    val ageLimit: Int,
    val imageUrl: String
)
