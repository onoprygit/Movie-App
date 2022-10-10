package com.onopry.movieapp.di

import com.onopry.movieapp.data.datasources.remote.movies.MovieDataSource
import com.onopry.movieapp.data.datasources.remote.movies.MovieRemoteDataSource
import com.onopry.movieapp.data.datasources.remote.network.RetrofitService
import com.onopry.movieapp.data.repositories.MoviesRepositoryImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    /* Network block */

    //OkHttp
    @Provides
    @Singleton
    fun provideInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    //Moshi
    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().build()

    //Retrofit
    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) = retrofit.create(RetrofitService::class.java)

    /* MovieDataSource */
    @Provides
    @Singleton
    fun provideRemoteDataSource(movieService: RetrofitService) =
        MovieRemoteDataSource(movieService = movieService)

    /* Repository */
    @Provides
    @Singleton
    fun provideRepository(movieRemoteDataSource: MovieRemoteDataSource) =
        MoviesRepositoryImpl(
            movieRemoteDataSource = movieRemoteDataSource
        )

}