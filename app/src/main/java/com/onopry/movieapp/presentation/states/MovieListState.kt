package com.onopry.movieapp.presentation.states

import com.onopry.movieapp.domain.models.MoviePreview

data class MovieListState(
    val isLoading: Boolean = false,
    val data: List<MoviePreview> = emptyList(),
    val message: String = ""
) 