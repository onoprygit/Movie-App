package com.onopry.movieapp.data.datasources.movies

import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.MovieListResponseBody
import com.onopry.movieapp.data.models.movie.MoviesDto
import com.onopry.movieapp.data.network.NetworkResult
import com.onopry.movieapp.data.network.handleResult
import com.onopry.movieapp.data.services.RetrofitService


class MovieRemoteDataSource(
    private val movieService: RetrofitService
) : MovieDataSource {

    private val apiKey = "e4833b4846dccc926e6dad24a6291ea8"

    override suspend fun fetchMovies() = handleResult {
        movieService.fetchMoviesPreviewList()
    }

    override fun fetchGenres(): List<GenreDto> {
        TODO("Not yet implemented")
    }

    override fun fetchActorsByMovieId(movieId: Int): List<ActorDto> {
        TODO("Not yet implemented")
    }
}