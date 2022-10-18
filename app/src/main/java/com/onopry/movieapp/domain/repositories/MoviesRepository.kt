package com.onopry.movieapp.domain.repositories

import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.details.MovieDetailsResponseBody
import com.onopry.movieapp.data.models.movie.preview.MovieListResponseBody

interface MoviesRepository {
    suspend fun fetchPreviews(): NetworkResult<MovieListResponseBody>
    suspend fun fetchDetails(id: Long): NetworkResult<MovieDetailsResponseBody>

    fun fetchGenres(): List<GenreDto>
}