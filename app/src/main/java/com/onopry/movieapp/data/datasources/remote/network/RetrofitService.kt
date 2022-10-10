package com.onopry.movieapp.data.datasources.remote.network

import com.onopry.movieapp.data.models.movie.MovieListResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("./movie/popular?api_key=e4833b4846dccc926e6dad24a6291ea8")
    suspend fun fetchMoviesPreviewList(
    ): Response<MovieListResponseBody>
}