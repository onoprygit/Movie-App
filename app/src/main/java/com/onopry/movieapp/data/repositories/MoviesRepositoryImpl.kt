package com.onopry.movieapp.data.repositories

import com.onopry.movieapp.data.datasources.movies.MovieDataSourceTestDataImpl
import com.onopry.movieapp.domain.repositories.MoviesRepository

class MoviesRepositoryImpl(
    private val movieDataSource: MovieDataSourceTestDataImpl
): MoviesRepository {
    override fun fetchMovies() = movieDataSource.fetchMovies()

    override fun fetchGenres() = movieDataSource.fetchGenres()
}