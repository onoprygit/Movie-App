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
    val releaseDatesAndCertification: ReleaseDatesAndCertification,

    @Json(name = "credits")
    val credits: Credits
)

/*
JSON EXAMPLE RESPONSE(only needed fields):
    {
    "backdrop_path": "/xWT5F1DNxciNLEMXRl49iq8zvN7.jpg",
    "budget": 24000000,
    "genres": [
        {
            "id": 14,
            "name": "Fantasy"
        },
        {
            "id": 16,
            "name": "Animation"
        },
        {
            "id": 10751,
            "name": "Family"
        }
    ],
    "id": 9479,
    "original_title": "The Nightmare Before Christmas",
    "overview": "Tired of scaring humans every October 31 with the same old bag of tricks, Jack Skellington, the spindly king of Halloween Town, kidnaps Santa Claus and plans to deliver shrunken heads and other ghoulish gifts to children on Christmas morning. But as Christmas approaches, Jack's rag-doll girlfriend, Sally, tries to foil his misguided plans.",
    "poster_path": "/oQffRNjK8e19rF7xVYEN8ew0j7b.jpg",
    "release_date": "1993-10-09",
    "revenue": 75634409,
    "runtime": 76,
    "tagline": "This is Halloween, everybody make a scene!",
    "title": "The Nightmare Before Christmas",
    "vote_average": 7.84,
    "release_dates": {
        "results": [
            {
                "iso_3166_1": "US",
                "release_dates": [
                    {
                        "certification": "",
                        "iso_639_1": null,
                        "note": "Re-Release",
                        "release_date": "2020-10-02T00:00:00.000Z",
                        "type": 2
                    },
                    {
                        "certification": "PG",
                        "iso_639_1": "",
                        "note": "",
                        "release_date": "1993-10-09T00:00:00.000Z",
                        "type": 3
                    }
                ]
            }
        ]
    }
}
*/