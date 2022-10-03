package com.onopry.movieapp.data.datasources.movies

import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.MoviesDto

interface MovieDataSource {
    fun fetchMovies(): List<MoviesDto>
    fun fetchGenres(): List<GenreDto>
    fun fetchActorsByMovieId(movieId: Int): List<ActorDto>
}