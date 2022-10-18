package com.onopry.movieapp.data.models.movie.preview

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieListResponseBody(
    @Json(name = "page")
    val page: Int,

    @Json(name = "results")
    val movies: List<MoviePreviewItemResponseBody>,

    @Json(name = "total_pages")
    val totalPages: Int,

    @Json(name = "total_results")
    val totalResults: Int
)