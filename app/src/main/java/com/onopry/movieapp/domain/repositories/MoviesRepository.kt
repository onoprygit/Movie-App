package com.onopry.movieapp.domain.repositories

import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.MoviesDto

interface MoviesRepository {
    fun fetchMovies(): List<MoviesDto>
    fun fetchGenres(): List<GenreDto>
}