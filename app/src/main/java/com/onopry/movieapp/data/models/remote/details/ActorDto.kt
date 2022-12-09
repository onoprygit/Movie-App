package com.onopry.movieapp.data.models.remote.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ActorDto(
    @Json(name = "id")
    val id: Long,

    @Json(name = "original_name")
    val name: String,

    @Json(name = "character")
    val character: String,

    @Json(name = "profile_path")
    val imageUrl: String?,

    @Json(name = "order")
    val order: Int
)
