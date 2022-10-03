package com.onopry.movieapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onopry.movieapp.domain.models.MoviePreview
import com.onopry.movieapp.domain.usecases.GetMoviePreviewUseCase

class MovieListViewModel(
    private val getMoviePreviewUseCase: GetMoviePreviewUseCase
) : ViewModel() {
    private val _moviesPreviews = MutableLiveData<List<MoviePreview>>(
        getMoviePreviewUseCase.execute()
    )
    val moviesPreviews: LiveData<List<MoviePreview>> = _moviesPreviews

    private fun fetchMovies(): List<MoviePreview> {
        return getMoviePreviewUseCase.execute()
    }

    fun refreshData() {
        _moviesPreviews.postValue(
            getMoviePreviewUseCase.execute()
        )
    }

}