package com.onopry.movieapp.common

open class AppException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(cause: Throwable) : super(cause)
}

class ConnectionException(
    cause: Throwable
) : AppException(cause = cause)

class BackendException(
    val code: Int,
    message: String
) : AppException(message = message)





