package com.onopry.movieapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onopry.movieapp.data.datasources.movies.MovieRemoteDataSource
import com.onopry.movieapp.data.network.RetrofitConfig
import com.onopry.movieapp.data.repositories.MoviesRepositoryImpl
import com.onopry.movieapp.data.services.RetrofitService
import com.onopry.movieapp.domain.mappers.MoviesPreviewListMapper
import com.onopry.movieapp.domain.usecases.GetMoviePreviewUseCase
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ViewModelsFactory : ViewModelProvider.Factory {

    private val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    private val moshi: Moshi = Moshi.Builder()
        .build()

    private val moshiConverterFactory: MoshiConverterFactory = MoshiConverterFactory.create(moshi)

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(client)
        .addConverterFactory(moshiConverterFactory)
        .build()

    private val movieApi = retrofit.create(RetrofitService::class.java)

//    private val movieTestDataSource by lazy { MovieDataSourceTestDataImpl() }
    private val movieRemoteDataSource by lazy { MovieRemoteDataSource(movieApi) }

    private val moviesRepository by lazy {
        MoviesRepositoryImpl(
//            movieTestDataSource,
            movieRemoteDataSource
        )
    }

    private val getMoviePreviewUseCase by lazy {
        GetMoviePreviewUseCase(
            repository = moviesRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(getMoviePreviewUseCase) as T
    }
}