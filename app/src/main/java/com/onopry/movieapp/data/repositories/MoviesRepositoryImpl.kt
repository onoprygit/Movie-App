package com.onopry.movieapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.onopry.movieapp.data.datasources.remote.movies.MoviePreviewsPagingSource
import com.onopry.movieapp.data.datasources.remote.movies.MovieRemoteDataSource
import com.onopry.movieapp.data.mappers.MovieDetailsMapper
import com.onopry.movieapp.data.mappers.MoviePreviewMapper
import com.onopry.movieapp.domain.models.MoviePreview
import com.onopry.movieapp.domain.repositories.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MoviesRepository {

    override fun fetchGenres() = movieRemoteDataSource.fetchGenres()

    override suspend fun fetchPreviews() =
        MoviePreviewMapper().transform(movieRemoteDataSource.fetchPreviews())


    override suspend fun fetchDetails(id: Long) =
        MovieDetailsMapper().transform(movieRemoteDataSource.fetchDetails(id))

    override fun getPagedPreviews(): Flow<PagingData<MoviePreview>> {
        val a = movieRemoteDataSource.fetchPagedPreviews().map { pagingData ->
            pagingData.map { moviePreviewItemResponseBody ->
                moviePreviewItemResponseBody.toDomainModel()
            }
        }
        return a
    }
}