package com.onopry.movieapp.domain.mappers

import com.onopry.movieapp.data.models.movie.preview.MoviePreviewItemResponseBody
import com.onopry.movieapp.data.models.movie.MoviesDto

class MoviesPreviewListMapper(
    private val itemMapper: Mapper<MoviesDto, MoviePreviewItemResponseBody>
) : Mapper<List<MoviesDto>, List<MoviePreviewItemResponseBody>> {
    override fun transform(data: List<MoviesDto>) = data.map { movie ->
        itemMapper.transform(movie)
    }
}