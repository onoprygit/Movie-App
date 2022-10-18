package com.onopry.movieapp.data.models.movie.details

import com.onopry.movieapp.data.models.actors.ActorDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Credits(
    @Json(name = "cast")
    val cast: Array<ActorDto>
)
