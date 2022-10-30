package com.onopry.movieapp.data.datasources.remote.movies

import androidx.paging.PagingData
import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.details.MovieDetailsResponseBody
import com.onopry.movieapp.data.models.movie.preview.MovieListResponseBody
import com.onopry.movieapp.data.models.movie.preview.MoviePreviewItemResponseBody
import com.onopry.movieapp.domain.models.MoviePreview
import kotlinx.coroutines.flow.Flow

interface MovieDataSource {
    suspend fun fetchPreviews(): NetworkResult<MovieListResponseBody>
    suspend fun fetchDetails(id: Long): NetworkResult<MovieDetailsResponseBody>
    fun fetchPagedPreviews(): Flow<PagingData<MoviePreviewItemResponseBody>>

    fun fetchGenres(): List<GenreDto>
    fun fetchActorsByMovieId(movieId: Int): List<ActorDto>
}