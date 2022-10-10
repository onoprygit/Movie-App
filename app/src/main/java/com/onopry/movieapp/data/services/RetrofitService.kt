package com.onopry.movieapp.data.services

import com.onopry.movieapp.data.models.movie.MovieListResponseBody
import com.onopry.movieapp.data.models.movie.MoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("./movie/popular?api_key=e4833b4846dccc926e6dad24a6291ea8")
    suspend fun fetchMoviesPreviewList(
        /*@Path("key") api_key: String*/
    ): Response<MovieListResponseBody>
}