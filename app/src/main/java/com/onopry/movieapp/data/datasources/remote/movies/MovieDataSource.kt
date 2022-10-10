package com.onopry.movieapp.data.datasources.remote.movies

import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.MovieListResponseBody

interface MovieDataSource {
    suspend fun fetchMovies(): NetworkResult<MovieListResponseBody>
    fun fetchGenres(): List<GenreDto>
    fun fetchActorsByMovieId(movieId: Int): List<ActorDto>
}