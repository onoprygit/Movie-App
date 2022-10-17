package com.onopry.movieapp.domain.mappers

import com.onopry.movieapp.data.models.movie.preview.MoviePreviewItemResponseBody
import com.onopry.movieapp.data.models.movie.MoviesDto

class MoviePreviewMapper : Mapper<MoviesDto, MoviePreviewItemResponseBody> {
    override fun transform(data: MoviesDto): MoviePreviewItemResponseBody {
        return MoviePreviewItemResponseBody(1,"1","1", 1f, "1", "1", listOf(1))/*, true,"1", listOf(1,1), "1", 1f.toDouble(), "1", false, 1)*/
    } /*= MoviePreviewItemResponseBody(
        id = data.id,
        originalTitle = data.title,
        description = data.description,
        imagePath = data.imageUrl,
        rating = data.rating.toFloat(),
        releaseDate = data.releaseDate
    )*/
}
