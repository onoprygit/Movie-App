package com.onopry.movieapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onopry.movieapp.data.datasources.remote.network.Error
import com.onopry.movieapp.data.datasources.remote.network.Exception
import com.onopry.movieapp.data.datasources.remote.network.Success
import com.onopry.movieapp.domain.usecases.GetMoviePreviewUseCase
import com.onopry.movieapp.presentation.states.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviePreviewUseCase: GetMoviePreviewUseCase
) : ViewModel() {
//    private val _moviesPreviews = MutableLiveData<List<MoviePreviewItemResponseBody>>()
//    val moviesPreviews: LiveData<List<MoviePreviewItemResponseBody>> = _moviesPreviews

    private val _moviePreviewStatus = MutableLiveData<MovieListState>()
    val moviePreviewStatus: LiveData<MovieListState> = _moviePreviewStatus

    private val _genresOfVisibleMovies = MutableLiveData<HashMap<Long, Int>>()
    val genresOfVisibleMovies: LiveData<HashMap<Long, Int>> = _genresOfVisibleMovies

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        _moviePreviewStatus.value = MovieListState(isLoading = true)
        viewModelScope.launch {
            when (val response = getMoviePreviewUseCase()) {
                is Success -> {
                    _moviePreviewStatus.postValue(MovieListState(data = response.data))
//                    _moviePreviewStatus.value = MovieListState(data = response.data)
                }
                is Error -> {
                    _moviePreviewStatus.postValue(
                        MovieListState(message = response.message.toString())
                    )
                }
                is Exception -> {
                    MovieListState(message = "Oops... Something went wrong.")
                }
            }
        }
    }

    fun refreshData() {

    }

}