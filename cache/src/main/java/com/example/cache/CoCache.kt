package com.example.cache

import com.example.cache.store.CacheStore
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class CoCache<T> constructor(
    private val cacheStore: CacheStore<T>
) : Cache<T> {

    override suspend fun get(key: String?, forceLoad: Boolean?, asyncValue: suspend () -> T): T =
        withContext(IO) {
            val resultCache = getCacheResult(key)
            if (forceLoad == false && resultCache != null) {
                resultCache
            } else {
                val value = asyncValue()
                saveCache(value, key)
                value
            }
        }

    private suspend fun saveCache(result: T, key: String?) {
        if (BuildConfig.ENABLE_CACHE_REQUEST) {
            key?.let { cacheStore.save(key, result) }
        }
    }

    private suspend fun getCacheResult(key: String?): T? =
        if (BuildConfig.ENABLE_CACHE_REQUEST) {
            key?.let { cacheStore.get(it) }
        } else {
            null
        }

    override suspend fun clearThisCache(key: String?) {
        key?.let { cacheStore.clear(it) }
    }

    override suspend fun clearAllCache() {
        cacheStore.clearAll()
    }
}
