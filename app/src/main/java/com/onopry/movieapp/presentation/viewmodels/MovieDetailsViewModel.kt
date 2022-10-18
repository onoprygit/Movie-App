package com.onopry.movieapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onopry.movieapp.data.datasources.remote.network.Error
import com.onopry.movieapp.data.datasources.remote.network.Exception
import com.onopry.movieapp.data.datasources.remote.network.Success
import com.onopry.movieapp.data.models.movie.details.MovieDetailsResponseBody
import com.onopry.movieapp.domain.mappers.Mapper
import com.onopry.movieapp.domain.mappers.MovieDetailsMapper
import com.onopry.movieapp.domain.models.MovieDetails
import com.onopry.movieapp.domain.usecases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val responseToModelMapper: MovieDetailsMapper
) : ViewModel() {

    private val _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails: LiveData<MovieDetails> = _movieDetails


    fun getMovieDetails(id: Long){
        viewModelScope.launch() {
            when(val response = getMovieDetailsUseCase.execute(id)){
                is Success -> {
                    val details = responseToModelMapper.transform(response.data)
                    _movieDetails.postValue(details)
                }
                is Error -> {}
                is Exception -> {}
            }
        }
    }
}