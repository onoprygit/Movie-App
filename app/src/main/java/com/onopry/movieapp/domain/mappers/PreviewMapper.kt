package com.onopry.movieapp.domain.mappers

import com.onopry.movieapp.data.models.movie.MoviePreviewItemResponseBody

class PreviewMapper : Mapper<MoviePreviewItemResponseBody, MoviePreviewItemResponseBody> {

    override fun transform(data: MoviePreviewItemResponseBody) = MoviePreviewItemResponseBody(
        id = data.id,
        originalTitle = data.originalTitle,
        description = data.description,
        imagePath = data.imagePath,
        rating = data.rating,
        releaseDate = data.releaseDate,
//        adult = false,
//        backdrop_path = "",
//        genre_ids = listOf<Int>(),
//        original_language = "orig",
//        popularity = 1.2,
//        title = "title",
//        video = false,
//        vote_count = 1
    )
}