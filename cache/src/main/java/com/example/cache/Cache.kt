package com.example.cache

interface Cache<T> {
    suspend fun get(key: String?, forceLoad: Boolean? = false, asyncValue: suspend () -> T): T
    suspend fun clearThisCache(key: String?)
    suspend fun clearAllCache()
}
