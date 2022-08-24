package com.example.util

inline fun <reified T : Any> List<Any>.castOrNull(): List<T> =
    mapNotNull {
        it as? T
    }
