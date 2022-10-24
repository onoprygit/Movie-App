package com.onopry.movieapp.di

import com.onopry.movieapp.data.repositories.MoviesRepositoryImpl
import com.onopry.movieapp.domain.usecases.GetMovieDetailsUseCase
import com.onopry.movieapp.domain.usecases.GetMoviePreviewUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetMoviePreviewUseCase(moviesRepository: MoviesRepositoryImpl) =
        GetMoviePreviewUseCase(
            repository = moviesRepository
        )

    @Provides
    fun provideGetMovieDetailsUseCase(
        moviesRepository: MoviesRepositoryImpl
    ) = GetMovieDetailsUseCase(
        repository = moviesRepository
    )
}