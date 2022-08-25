package com.example.util

import timber.log.Timber

private val classMap = mutableMapOf<String, Class<*>>()

fun <T> loadClassOrNull(className: String): Class<out T>? {
    return classMap.getOrPut(className) {
        try {
            Class.forName(className)
        } catch (e: ClassNotFoundException) {
            Timber.e(e)
            return null
        }
    }.castOrNull()
}
