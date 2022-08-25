package com.example.util

inline fun <reified T> Any.castOrNull(): T? =
    if (this is T) {
        this
    } else {
        null
    }
