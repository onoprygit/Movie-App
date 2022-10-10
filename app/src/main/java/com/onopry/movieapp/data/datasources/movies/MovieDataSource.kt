package com.onopry.movieapp.data.datasources.movies

import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.MovieListResponseBody
import com.onopry.movieapp.data.models.movie.MoviesDto
import com.onopry.movieapp.data.network.NetworkResult

interface MovieDataSource {
//    fun fetchMovies(): List<MoviesDto>
    suspend fun fetchMovies(): NetworkResult<MovieListResponseBody>
    fun fetchGenres(): List<GenreDto>
    fun fetchActorsByMovieId(movieId: Int): List<ActorDto>
}