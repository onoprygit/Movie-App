package com.onopry.movieapp.domain.repositories

import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.details.MovieDetailsResponseBody
import com.onopry.movieapp.data.models.movie.preview.MovieListResponseBody
import com.onopry.movieapp.domain.models.MovieDetails
import com.onopry.movieapp.domain.models.MoviePreview

interface MoviesRepository {
    suspend fun fetchPreviews(): NetworkResult<List<MoviePreview>>
    suspend fun fetchDetails(id: Long): NetworkResult<MovieDetails>

    fun fetchGenres(): List<GenreDto>
}