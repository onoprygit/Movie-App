package com.onopry.movieapp.data.datasources.remote.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

sealed interface NetworkResult<T : Any>

class Success<T : Any>(val data: T) : NetworkResult<T>

class Error<T : Any>(val code: Int, val message: String?) : NetworkResult<T>

class Exception<T : Any>(val exception: Throwable) : NetworkResult<T>

suspend fun <T : Any> safeApiCall(
    dispatcher: CoroutineDispatcher,
    execute: suspend () -> Response<T>
): NetworkResult<T> {
    return withContext(dispatcher) {
        try {
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
}