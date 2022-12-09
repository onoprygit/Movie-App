package com.onopry.movieapp.data.datasources.remote.movies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.onopry.movieapp.data.datasources.remote.network.MovieDbApi
import com.onopry.movieapp.data.datasources.remote.network.safeApiCall
import com.onopry.movieapp.data.models.remote.details.ActorDto
import com.onopry.movieapp.data.models.remote.GenreDto
import com.onopry.movieapp.data.models.remote.preview.MoviePreviewItemResponseBody
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieDbApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieDataSource {

    override suspend fun fetchPreviews() = safeApiCall(dispatcher) {
        movieService.fetchMoviesPreviewList()
    }

    override suspend fun fetchDetails(id: Long) = safeApiCall(dispatcher) {
        movieService.fetchMovieDetails(id)
    }

    override fun fetchPagedPreviews(): Flow<PagingData<MoviePreviewItemResponseBody>> {
        return Pager(
            config = PagingConfig(
                pageSize = API_PAGE_SIZE,
                enablePlaceholders = false,
                initialLoadSize = API_PAGE_SIZE * 2
            ),
            pagingSourceFactory = {
                MoviePreviewsPagingSource(movieService)
            }
        ).flow
    }


    override fun fetchGenres(): List<GenreDto> {
        TODO("Not yet implemented")
    }

    override fun fetchActorsByMovieId(movieId: Int): List<ActorDto> {
        TODO("Not yet implemented")
    }

    companion object {
        const val API_PAGE_SIZE = 20
    }
}