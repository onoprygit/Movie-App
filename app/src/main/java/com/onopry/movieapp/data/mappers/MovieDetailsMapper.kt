package com.onopry.movieapp.data.mappers

import com.onopry.movieapp.data.datasources.remote.network.Error
import com.onopry.movieapp.data.datasources.remote.network.Exception
import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.datasources.remote.network.Success
import com.onopry.movieapp.data.models.remote.details.MovieDetailsResponseBody
import com.onopry.movieapp.domain.models.MovieDetails
import java.time.LocalDate

class MovieDetailsMapper :
    Mapper<NetworkResult<MovieDetailsResponseBody>, NetworkResult<MovieDetails>> {

    override fun transform(data: NetworkResult<MovieDetailsResponseBody>) =
        when (data) {
            is Success -> {
                Success(
                    data = MovieDetails(
                        budget = data.data.budget,
                        genres = data.data.genres,
                        id = data.data.id,
                        overview = data.data.overview,
                        poster = data.data.poster,
                        moviePremiereDate = localDateFromString(data.data.moviePremiereDate),
                        revenue = data.data.revenue,
                        runtime = data.data.runtime,
                        tagline = data.data.tagline,
                        title = data.data.title,
                        userRating = data.data.userRating,
                        certification = extractCertification(data.data),
                        cast = data.data.credits.cast
                    )
                )
            }
            is Error -> Error(code = data.code, message = data.message)
            is Exception -> Exception(exception = data.exception)
        }

    private fun extractCertification(data: MovieDetailsResponseBody) =
        data
            .releaseDatesAndCertification
            .results.firstOrNull { certifications -> certifications.iso == "US" }
            ?.releaseDates
            ?.get(0)
            ?.certification ?: "N/A"

    private fun localDateFromString(date: String) = LocalDate.parse(date)
}


