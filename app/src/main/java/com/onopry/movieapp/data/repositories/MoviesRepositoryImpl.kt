package com.onopry.movieapp.data.repositories

import com.onopry.movieapp.data.datasources.remote.movies.MovieRemoteDataSource
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.domain.repositories.MoviesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject constructor(
    /*private val movieTestDataSource: MovieDataSourceTestDataImpl,*/
    val movieRemoteDataSource: MovieRemoteDataSource
) : MoviesRepository {

    private val genresList = listOf<GenreDto>()

    override fun fetchGenres() = movieRemoteDataSource.fetchGenres()

    //    override fun fetchMovies() = movieTestDataSource.fetchMovies()
    override suspend fun fetchPreviews() = movieRemoteDataSource.fetchPreviews()

    override suspend fun fetchDetails(id: Long) = movieRemoteDataSource.fetchDetails(id)


}