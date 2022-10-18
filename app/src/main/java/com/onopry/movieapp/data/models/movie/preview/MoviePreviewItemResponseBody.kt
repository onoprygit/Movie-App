package com.onopry.movieapp.data.models.movie.preview

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviePreviewItemResponseBody(
    @Json(name = "id")
    val id: Long,

    @Json(name = "original_title")
    val originalTitle: String,

    @Json(name = "overview")
    val description: String,

    @Json(name = "vote_average")
    val rating: Float,

    @Json(name = "release_date")
    val releaseDate: String,

    @Json(name = "poster_path")
    val imagePath: String?,

    @Json(name = "genre_ids")
    val genreIds: List<Int>
)