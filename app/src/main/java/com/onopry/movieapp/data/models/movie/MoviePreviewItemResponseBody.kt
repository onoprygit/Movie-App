package com.onopry.movieapp.data.models.movie

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviePreviewItemResponseBody(
    @Json(name = "id")
    val id: Int,

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



    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val original_language: String,
    val popularity: Double,
    val title: String,
    val video: Boolean,
    val vote_count: Int

    /*
    val id: Int,
    val original_title: String,
    val overview: String,
    val vote_average: Double,
    val release_date: String,
    val poster_path: String,
    */
)