package com.onopry.movieapp.data.mappers

import com.onopry.movieapp.data.datasources.remote.network.Error
import com.onopry.movieapp.data.datasources.remote.network.Exception
import com.onopry.movieapp.data.datasources.remote.network.NetworkResult
import com.onopry.movieapp.data.datasources.remote.network.Success
import com.onopry.movieapp.data.models.remote.preview.MovieListResponseBody
import com.onopry.movieapp.domain.models.MoviePreview

class MoviePreviewMapper :
    Mapper<NetworkResult<MovieListResponseBody>, NetworkResult<List<MoviePreview>>> {

    override fun transform(data: NetworkResult<MovieListResponseBody>) =
        when (data) {
            is Success -> {
                Success(
                    data.data.movies.map { previewItemResponseBody ->
                        previewItemResponseBody.toDomainModel()
                    }
                )
            }
            is Error -> Error(code = data.code, message = data.message)
            is Exception -> Exception(exception = data.exception)
        }
}