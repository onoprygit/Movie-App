package com.onopry.movieapp.domain.usecases

import com.onopry.movieapp.data.models.movie.details.MovieDetailsResponseBody
import com.onopry.movieapp.data.mappers.Mapper
import com.onopry.movieapp.domain.models.MovieDetails
import com.onopry.movieapp.domain.repositories.MoviesRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MoviesRepository
){
    suspend operator fun invoke(id: Long) = repository.fetchDetails(id)
}