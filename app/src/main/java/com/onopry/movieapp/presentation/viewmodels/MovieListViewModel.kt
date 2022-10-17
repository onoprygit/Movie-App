package com.onopry.movieapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onopry.movieapp.data.datasources.remote.network.Error
import com.onopry.movieapp.data.datasources.remote.network.Exception
import com.onopry.movieapp.data.datasources.remote.network.Success
import com.onopry.movieapp.data.models.movie.preview.MoviePreviewItemResponseBody
import com.onopry.movieapp.domain.usecases.GetMoviePreviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    val getMoviePreviewUseCase: GetMoviePreviewUseCase
) : ViewModel() {
    private val _moviesPreviews = MutableLiveData<List<MoviePreviewItemResponseBody>>()
    val moviesPreviews: LiveData<List<MoviePreviewItemResponseBody>> = _moviesPreviews

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            when (val response = getMoviePreviewUseCase.execute()) {
                is Success -> {
                    _moviesPreviews.postValue(response.data.movies)
                    Log.d("ViewModelTAG", "fetchMovies: ${response.data.movies.size}")
                }
                is Error -> {}
                is Exception -> {}
            }
        }
    }

    fun refreshData() {

    }

}