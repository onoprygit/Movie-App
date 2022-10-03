package com.onopry.movieapp.domain.models

import java.util.*

class MoviePreview(
    val id: Int,
    val movieTitle: String,
    val description: String,
    val imageUrl: String,
    val rating: Int,
    val ageLimit: Int
)
