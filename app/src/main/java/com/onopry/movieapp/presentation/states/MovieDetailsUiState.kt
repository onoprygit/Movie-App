package com.onopry.movieapp.presentation.states

import com.onopry.movieapp.domain.models.MovieDetails

data class MovieDetailsUiState(
    val isLoading: Boolean = false,
    val data: MovieDetails? = null,
    val errorMessage: String = ""
)