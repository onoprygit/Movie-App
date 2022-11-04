package com.onopry.movieapp.domain.usecases

import com.onopry.movieapp.domain.repositories.MoviesRepository
import javax.inject.Inject

class GetPagingMoviePreviewsUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke() = repository.getPagedPreviews()
}