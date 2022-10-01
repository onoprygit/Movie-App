package com.onopry.movieapp.data.datasources.movies

import com.onopry.movieapp.data.models.movie.Movie

interface MovieDataSourse {
    fun getMovies(): List<Movie>
}