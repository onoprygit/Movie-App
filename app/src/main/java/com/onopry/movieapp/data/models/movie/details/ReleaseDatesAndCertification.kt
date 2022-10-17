package com.onopry.movieapp.data.models.movie.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReleaseDatesAndCertification(
    @Json(name = "results")
    val results: Array<Certifications>
)
