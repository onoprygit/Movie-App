package com.onopry.movieapp.data.repositories

import com.onopry.movieapp.data.datasources.remote.movies.MovieRemoteDataSource
import com.onopry.movieapp.domain.repositories.MoviesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject constructor (
    /*private val movieTestDataSource: MovieDataSourceTestDataImpl,*/
    val movieRemoteDataSource: MovieRemoteDataSource
): MoviesRepository {
//    override fun fetchMovies() = movieTestDataSource.fetchMovies()
    override suspend fun fetchMovies() = movieRemoteDataSource.fetchMovies()

    override fun fetchGenres() = movieRemoteDataSource.fetchGenres()
}