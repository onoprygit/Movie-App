package com.onopry.movieapp.domain.usecases

import com.onopry.movieapp.data.models.movie.details.MovieDetailsResponseBody
import com.onopry.movieapp.domain.mappers.Mapper
import com.onopry.movieapp.domain.models.MovieDetails
import com.onopry.movieapp.domain.repositories.MoviesRepository

class GetMovieDetailsUseCase(
    val repository: MoviesRepository,
    val mapper: Mapper<MovieDetailsResponseBody, MovieDetails>
//    val mapper: MovieDetailsMapper
) {
    suspend fun execute(id: Long) = repository.fetchDetails(id)

}