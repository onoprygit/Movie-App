package com.onopry.movieapp.data.datasources.remote.movies

import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.details.MovieDetailsResponseBody
import com.onopry.movieapp.data.models.movie.preview.MovieListResponseBody

interface MovieDataSource {
    suspend fun fetchPreviews(): NetworkResult<MovieListResponseBody>
    suspend fun fetchDetails(id: Long): NetworkResult<MovieDetailsResponseBody>

    fun fetchGenres(): List<GenreDto>
    fun fetchActorsByMovieId(movieId: Int): List<ActorDto>
}