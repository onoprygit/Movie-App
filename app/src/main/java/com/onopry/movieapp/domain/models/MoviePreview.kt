package com.onopry.movieapp.domain.models

data class MoviePreview(
    val id: Long,
    val originalTitle: String,
    val description: String,
    val rating: Float,
    val releaseDate: String,
    val imagePath: String?,
    val genreIds: List<Int>
)