package com.onopry.movieapp.data.datasources.remote

import com.onopry.movieapp.data.datasources.remote.movies.MovieDataSource
import com.onopry.movieapp.data.datasources.remote.network.RetrofitService
import com.onopry.movieapp.data.datasources.remote.network.safeApiCall
import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class MovieRemoteDataSource(
    private val movieService: RetrofitService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieDataSource {

    private val apiKey = "e4833b4846dccc926e6dad24a6291ea8"

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