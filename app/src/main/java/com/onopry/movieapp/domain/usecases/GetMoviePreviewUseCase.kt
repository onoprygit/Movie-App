package com.onopry.movieapp.domain.usecases

import com.onopry.movieapp.domain.repositories.MoviesRepository

class GetMoviePreviewUseCase(
    private val repository: MoviesRepository/*,
    private val moviesListMapper: Mapper<List<MoviesDto>, List<MoviePreview>>*/
) {
    suspend fun execute() = repository.fetchMovies()
}
