package com.onopry.movieapp.data.repositories

import com.onopry.movieapp.data.datasources.movies.MovieRemoteDataSource
import com.onopry.movieapp.domain.repositories.MoviesRepository

class MoviesRepositoryImpl(
    /*private val movieTestDataSource: MovieDataSourceTestDataImpl,*/
    private val movieRemoteDataSource: MovieRemoteDataSource
): MoviesRepository {
//    override fun fetchMovies() = movieTestDataSource.fetchMovies()
    override suspend fun fetchMovies() = movieRemoteDataSource.fetchMovies()

    override fun fetchGenres() = movieRemoteDataSource.fetchGenres()
}