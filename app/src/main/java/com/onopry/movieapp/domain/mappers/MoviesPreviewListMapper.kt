package com.onopry.movieapp.domain.mappers

import com.onopry.movieapp.data.models.movie.MoviesDto
import com.onopry.movieapp.domain.models.MoviePreview

class MoviesPreviewListMapper(
    private val itemMapper: Mapper<MoviesDto, MoviePreview>
) : Mapper<List<MoviesDto>, List<MoviePreview>> {
    override fun transform(data: List<MoviesDto>) = data.map { movie ->
        itemMapper.transform(movie)
    }
}