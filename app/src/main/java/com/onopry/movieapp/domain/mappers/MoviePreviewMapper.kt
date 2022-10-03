package com.onopry.movieapp.domain.mappers

import com.onopry.movieapp.data.models.movie.MoviesDto
import com.onopry.movieapp.domain.models.MoviePreview

class MoviePreviewMapper : Mapper<MoviesDto, MoviePreview> {
    override fun transform(data: MoviesDto) = MoviePreview(
        id = data.id,
        movieTitle = data.title,
        description = data.description,
        imageUrl = data.imageUrl,
        rating = data.rating,
        ageLimit = data.ageLimit
    )
}