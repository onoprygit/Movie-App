package com.onopry.movieapp.domain.usecases

import com.onopry.movieapp.data.models.movie.MoviesDto
import com.onopry.movieapp.domain.mappers.Mapper
import com.onopry.movieapp.domain.models.MoviePreview
import com.onopry.movieapp.domain.repositories.MoviesRepository

class GetMoviePreviewUseCase(
    private val repository: MoviesRepository,
    private val moviesListMapper: Mapper<List<MoviesDto>, List<MoviePreview>>
) {
    fun execute() = moviesListMapper
        .transform(
            repository.fetchMovies()
        )
}