package com.onopry.movieapp.data.network

import retrofit2.HttpException
import retrofit2.Response

suspend fun <T : Any> handleResult(
    execute: suspend () -> Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null)
            Success(body)
        else
            Error(code = response.code(), message = response.message())
    } catch (e: HttpException) {
        Error(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        Exception(e)
    }
}