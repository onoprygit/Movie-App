package com.onopry.movieapp.domain.repositories

import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.MovieListResponseBody

interface MoviesRepository {
    suspend fun fetchMovies(): NetworkResult<MovieListResponseBody>
    fun fetchGenres(): List<GenreDto>
}