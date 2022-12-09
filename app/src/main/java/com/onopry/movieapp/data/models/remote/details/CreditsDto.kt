package com.onopry.movieapp.data.models.remote.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreditsDto(
    @Json(name = "cast")
    val cast: Array<ActorDto>
)
