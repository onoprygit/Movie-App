package com.onopry.movieapp.data.models.movie.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReleaseDatesDto(
    @Json(name = "certification")
    val certification: String,

    @Json(name = "type")
    val type: Int,

    @Json(name = "release_date")
    val releaseDate: String
)
