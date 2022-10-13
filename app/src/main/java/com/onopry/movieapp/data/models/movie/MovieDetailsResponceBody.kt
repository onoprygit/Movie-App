package com.onopry.movieapp.data.models.movie

import com.onopry.movieapp.data.models.genre.GenreDto
import com.squareup.moshi.Json

data class MovieDetailsResponseBody(
    @Json(name = "id")
    val id: Long,

    @Json(name = "budget")
    val budget: Int,

    @Json(name = "genres")
    val genres: Array<GenreDto>,

    @Json(name = "poster_path")
    val poster: String,

    @Json(name = "runtime")
    val runtime: Int,

    @Json(name = "title")
    val title: String,

    @Json(name = "overview")
    val overview: String,

    @Json(name = "release_date")
    val releaseDate: String,

    @Json(name = "vote_average")
    val rating: Float
)