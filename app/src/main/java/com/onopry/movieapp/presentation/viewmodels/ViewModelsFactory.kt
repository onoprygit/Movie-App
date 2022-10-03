package com.onopry.movieapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onopry.movieapp.data.datasources.movies.MovieDataSourceTestDataImpl
import com.onopry.movieapp.data.repositories.MoviesRepositoryImpl
import com.onopry.movieapp.domain.mappers.MoviePreviewMapper
import com.onopry.movieapp.domain.mappers.MoviesPreviewListMapper
import com.onopry.movieapp.domain.usecases.GetMoviePreviewUseCase

class ViewModelsFactory : ViewModelProvider.Factory {
    private val movieDataSource by lazy { MovieDataSourceTestDataImpl() }
    private val moviesRepository by lazy { MoviesRepositoryImpl(movieDataSource = movieDataSource) }

    private val getMoviePreviewUseCase by lazy {
        GetMoviePreviewUseCase(
            repository = moviesRepository,
            moviesListMapper = MoviesPreviewListMapper(MoviePreviewMapper())
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(getMoviePreviewUseCase) as T
    }
}