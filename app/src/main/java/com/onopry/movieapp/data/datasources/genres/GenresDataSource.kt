package com.onopry.movieapp.data.datasources.genres

import com.onopry.movieapp.data.models.genre.Genre

interface GenresDataSource {
    fun getGenres(): List<Genre>
}