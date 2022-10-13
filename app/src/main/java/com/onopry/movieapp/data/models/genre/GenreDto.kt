package com.onopry.movieapp.data.models.genre

import com.squareup.moshi.Json

data class GenreDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)
