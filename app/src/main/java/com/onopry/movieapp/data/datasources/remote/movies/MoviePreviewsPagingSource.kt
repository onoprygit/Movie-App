package com.onopry.movieapp.data.datasources.remote.movies

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.onopry.movieapp.common.logDebug
import com.onopry.movieapp.data.datasources.remote.network.MovieDbApi
import com.onopry.movieapp.data.models.movie.preview.MoviePreviewItemResponseBody
import retrofit2.HttpException
import java.io.IOException

class MoviePreviewsPagingSource(
    private val movieApi: MovieDbApi,
    private val pageSize: Int
) : PagingSource<Int, MoviePreviewItemResponseBody>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviePreviewItemResponseBody> {
        return try {
            val pageIndex = params.key ?: 1
            val response = movieApi.fetchPagingMoviesPreviewList(pageIndex)
            val responseData = mutableListOf<MoviePreviewItemResponseBody>()
            val data = response.body()?.movies ?: emptyList()
            responseData.addAll(data)

            logDebug(params.loadSize.toString())

            LoadResult.Page(
                data = responseData,
                prevKey = if (pageIndex == 1) null else -1,
                //                nextKey = if (responseData.size == params.loadSize) pageIndex + (params.loadSize / pageSize) else null
                nextKey = pageIndex + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MoviePreviewItemResponseBody>) =
        state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey
        }
}