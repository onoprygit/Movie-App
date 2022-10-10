package com.onopry.movieapp.data.datasources.remote.genres

import com.onopry.movieapp.data.models.genre.GenreDto

interface GenresDataSource {
    fun getGenres(): List<GenreDto>
}