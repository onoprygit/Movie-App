package com.onopry.movieapp.domain.usecases

import com.onopry.movieapp.domain.repositories.MoviesRepository
import javax.inject.Inject

class GetMoviePreviewUseCase @Inject constructor(
    private val repository: MoviesRepository/*,
    private val moviesListMapper: Mapper<List<MoviesDto>, List<MoviePreview>>*/
) {
    suspend fun execute() = repository.fetchPreviews()
}
