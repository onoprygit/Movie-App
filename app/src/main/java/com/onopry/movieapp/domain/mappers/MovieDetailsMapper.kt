package com.onopry.movieapp.domain.mappers

import com.onopry.movieapp.data.models.movie.details.MovieDetailsResponseBody
import com.onopry.movieapp.domain.models.MovieDetails
import java.time.LocalDate
import javax.inject.Singleton

@Singleton
class MovieDetailsMapper : Mapper<MovieDetailsResponseBody, MovieDetails> {

    override fun transform(data: MovieDetailsResponseBody) = MovieDetails(
        budget = data.budget,
        genres = data.genres,
        id = data.id,
        overview = data.overview,
        poster = data.poster,
        moviePremiereDate = localDateFromString(data.moviePremiereDate),
        revenue = data.revenue,
        runtime = data.runtime,
        tagline = data.tagline,
        title = data.title,
        userRating = data.userRating,
        certification = extractCertification(data)
    )

    private fun extractCertification(data: MovieDetailsResponseBody) =
        data
            .releaseDatesAndCertification
            .results.firstOrNull { certifications -> certifications.iso == "US" }
            ?.releaseDates
            ?.get(0)
            ?.certification ?: "N/A"

    private fun localDateFromString(date: String) = LocalDate.parse(date)

}


