package com.onopry.movieapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onopry.movieapp.data.datasources.remote.network.Error
import com.onopry.movieapp.data.datasources.remote.network.Exception
import com.onopry.movieapp.data.datasources.remote.network.Success
import com.onopry.movieapp.domain.usecases.GetMovieDetailsUseCase
import com.onopry.movieapp.presentation.states.MovieDetailsUiState
import com.onopry.movieapp.presentation.states.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private val _movieDetails = MutableLiveData<MovieDetailsUiState>()
    val movieDetails: LiveData<MovieDetailsUiState> = _movieDetails


    fun getMovieDetails(id: Long){
        _movieDetails.value = MovieDetailsUiState(isLoading = true)
        viewModelScope.launch() {
            when(val response = getMovieDetailsUseCase(id)){
                is Success -> {
                    _movieDetails.postValue(MovieDetailsUiState(data = response.data))
                }
                is Error -> {
                    _movieDetails.postValue(MovieDetailsUiState(errorMessage = response.message ?: "An unexpected error occured"))
                }
                is Exception -> {
                    MovieListState(message = "Oops... Something went wrong.")
                }
            }
        }
    }
}