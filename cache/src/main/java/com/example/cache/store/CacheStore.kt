package com.example.cache.store

interface CacheStore<T> {
    suspend fun save(key: String, value: T)
    suspend fun get(key: String): T?
    suspend fun clear(key: String)
    suspend fun clearAll()
}
