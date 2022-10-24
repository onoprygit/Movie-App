package com.onopry.movieapp.data.models.movie.details

import com.onopry.movieapp.data.models.genre.GenreDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailsResponseBody(
    @Json(name = "backdrop_path")
    val backdrop_path: String,

    @Json(name = "budget")
    val budget: Int,

    @Json(name = "genres")
    val genres: Array<GenreDto>,

    @Json(name = "id")
    val id: Long,

    @Json(name = "overview")
    val overview: String,

    @Json(name = "poster_path")
    val poster: String,

    @Json(name = "release_date")
    val moviePremiereDate: String,

    @Json(name = "revenue")
    val revenue: Int,

    @Json(name = "runtime")
    val runtime: Int,

    @Json(name = "tagline")
    val tagline: String,

    @Json(name = "title")
    val title: String,

    @Json(name = "vote_average")
    val userRating: Float,

    @Json(name = "release_dates")
    val releaseDatesAndCertification: ReleaseDatesAndCertificationDto,

    @Json(name = "credits")
    val credits: CreditsDto
)