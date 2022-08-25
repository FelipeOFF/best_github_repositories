package com.example.domain.util

import com.example.domain.ErrorWrapper
import com.example.domain.ResultWrapper

inline fun <reified T> ResultWrapper<T>.asSuccessValueOrNull(): T? =
    (this as? ResultWrapper.Success<T>)?.value

inline fun <reified T> ResultWrapper<T>.asErrorServerOrNull(): ErrorWrapper.Server? =
    (this as? ResultWrapper.Error)?.error as? ErrorWrapper.Server

fun ErrorWrapper.asErrorThrowableOrNull(): Throwable? =
    when (this) {
        is ErrorWrapper.Server -> cause
        is ErrorWrapper.NetworkException -> cause
        is ErrorWrapper.UnknownException -> cause
    }
