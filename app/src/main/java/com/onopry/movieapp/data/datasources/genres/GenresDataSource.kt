package com.onopry.movieapp.data.datasources.genres

import com.onopry.movieapp.data.models.genre.GenreDto

interface GenresDataSource {
    fun getGenres(): List<GenreDto>
}