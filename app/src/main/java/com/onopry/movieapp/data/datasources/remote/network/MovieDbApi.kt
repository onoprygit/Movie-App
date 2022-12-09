package com.onopry.movieapp.data.datasources.remote.network

import com.onopry.movieapp.data.models.remote.details.MovieDetailsResponseBody
import com.onopry.movieapp.data.models.remote.preview.MovieListResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface MovieDbApi {

    //todo: rewrite
    @GET("./movie/popular?api_key=e4833b4846dccc926e6dad24a6291ea8")
    suspend fun fetchMoviesPreviewList(): Response<MovieListResponseBody>

    @GET("./movie/popular?api_key=e4833b4846dccc926e6dad24a6291ea8")
    suspend fun fetchPagingMoviesPreviewList(@Query("page") pageNumber: Int = 1): Response<MovieListResponseBody>

    @GET("movie/{movie_id}?api_key=e4833b4846dccc926e6dad24a6291ea8&append_to_response=release_dates,credits")
    suspend fun fetchMovieDetails(@Path("movie_id") movieId: Long): Response<MovieDetailsResponseBody>
}
