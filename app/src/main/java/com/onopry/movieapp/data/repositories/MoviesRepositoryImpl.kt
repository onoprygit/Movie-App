package com.onopry.movieapp.data.repositories

import com.onopry.movieapp.data.datasources.remote.movies.MovieRemoteDataSource
import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.datasources.remote.network.safeApiCall
import com.onopry.movieapp.data.mappers.MovieDetailsMapper
import com.onopry.movieapp.data.mappers.MoviePreviewMapper
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.preview.MovieListResponseBody
import com.onopry.movieapp.domain.models.MoviePreview
import com.onopry.movieapp.domain.repositories.MoviesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject constructor(
    /*private val movieTestDataSource: MovieDataSourceTestDataImpl,*/
    val movieRemoteDataSource: MovieRemoteDataSource
) : MoviesRepository {

    override fun fetchGenres() = movieRemoteDataSource.fetchGenres()

    //    override fun fetchMovies() = movieTestDataSource.fetchMovies()
    override suspend fun fetchPreviews() =
        MoviePreviewMapper().transform(movieRemoteDataSource.fetchPreviews())


    override suspend fun fetchDetails(id: Long) =
        MovieDetailsMapper().transform(movieRemoteDataSource.fetchDetails(id))


}