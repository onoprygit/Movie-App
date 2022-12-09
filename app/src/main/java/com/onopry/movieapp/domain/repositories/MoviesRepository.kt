package com.onopry.movieapp.domain.repositories

import androidx.paging.PagingData
import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.models.remote.GenreDto
import com.onopry.movieapp.domain.models.MovieDetails
import com.onopry.movieapp.domain.models.MoviePreview
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun fetchPreviews(): NetworkResult<List<MoviePreview>>
    suspend fun fetchDetails(id: Long): NetworkResult<MovieDetails>

    fun getPagedPreviews(): Flow<PagingData<MoviePreview>>

    fun fetchGenres(): List<GenreDto>
}