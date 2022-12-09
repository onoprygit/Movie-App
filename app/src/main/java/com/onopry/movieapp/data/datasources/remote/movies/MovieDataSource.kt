package com.onopry.movieapp.data.datasources.remote.movies

import androidx.paging.PagingData
import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.models.remote.details.ActorDto
import com.onopry.movieapp.data.models.remote.GenreDto
import com.onopry.movieapp.data.models.remote.details.MovieDetailsResponseBody
import com.onopry.movieapp.data.models.remote.preview.MovieListResponseBody
import com.onopry.movieapp.data.models.remote.preview.MoviePreviewItemResponseBody
import kotlinx.coroutines.flow.Flow

interface MovieDataSource {
    suspend fun fetchPreviews(): NetworkResult<MovieListResponseBody>
    suspend fun fetchDetails(id: Long): NetworkResult<MovieDetailsResponseBody>
    fun fetchPagedPreviews(): Flow<PagingData<MoviePreviewItemResponseBody>>

    fun fetchGenres(): List<GenreDto>
    fun fetchActorsByMovieId(movieId: Int): List<ActorDto>
}