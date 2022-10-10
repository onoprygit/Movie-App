package com.onopry.movieapp.domain.repositories

import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.MovieListResponseBody
import com.onopry.movieapp.data.models.movie.MoviesDto
import com.onopry.movieapp.data.network.NetworkResult

interface MoviesRepository {
    suspend fun fetchMovies(): NetworkResult<MovieListResponseBody>
    fun fetchGenres(): List<GenreDto>
}