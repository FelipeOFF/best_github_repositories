package com.example.domain

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Error(val error: ErrorWrapper) : ResultWrapper<Nothing>()
    object Loading : ResultWrapper<Nothing>()
    object DismissLoading : ResultWrapper<Nothing>()
}

sealed class ErrorWrapper {
    data class Server(
        val code: Int,
        val message: String? = null,
        val cause: Throwable? = null
    ) : ErrorWrapper()

    data class NetworkException(
        val cause: Throwable?
    ) : ErrorWrapper()

    data class UnknownException(
        val cause: Throwable?
    ) : ErrorWrapper()
}
