package com.onopry.movieapp.data.models.remote.details

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReleaseDatesAndCertificationDto(
    @Json(name = "results")
    val results: Array<CertificationsDto>
)
