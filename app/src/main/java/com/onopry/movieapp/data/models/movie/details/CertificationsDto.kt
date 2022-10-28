package com.onopry.movieapp.data.models.movie.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CertificationsDto(
    @Json(name = "iso_3166_1")
    val iso: String,

    @Json(name = "release_dates")
    val releaseDates: Array<ReleaseDatesDto>
)
