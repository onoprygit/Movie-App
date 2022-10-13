package com.onopry.movieapp.data.datasources.remote.movies

import com.onopry.movieapp.data.datasources.remote.network.MovieDbApi
import com.onopry.movieapp.data.datasources.remote.network.safeApiCall
import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MovieRemoteDataSource @Inject constructor(
    val movieService: MovieDbApi,
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieDataSource {

    override suspend fun fetchMovies() = safeApiCall(dispatcher) {
        movieService.fetchMoviesPreviewList()
    }

    override fun fetchGenres(): List<GenreDto> {
        TODO("Not yet implemented")
    }

    override fun fetchActorsByMovieId(movieId: Int): List<ActorDto> {
        TODO("Not yet implemented")
    }
}