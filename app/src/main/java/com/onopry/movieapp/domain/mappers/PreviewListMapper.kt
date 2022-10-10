package com.onopry.movieapp.domain.mappers

import com.onopry.movieapp.data.models.movie.MovieListResponseBody
import com.onopry.movieapp.data.models.movie.MoviePreviewItemResponseBody

class PreviewListMapper(
    private val previewMapper: PreviewMapper
) : Mapper<MovieListResponseBody, List<MoviePreviewItemResponseBody>> {
    override fun transform(data: MovieListResponseBody) =
        data.movies.map { movieItem ->
            previewMapper.transform(movieItem)
        }

}