package com.example.cache.store

import com.example.util.LOCAL_DEFAULT
import com.orhanobut.hawk.Hawk
import timber.log.Timber
import java.util.Calendar

class HawkCacheStore<T> constructor(
    private val lifeTimeMs: Long = DEFAULT_LIFE_TIME
) : CacheStore<T> {

    override suspend fun save(key: String, value: T) {
        Timber.d("Save cache of key = $key")
        Hawk.put("${key}_$CREATE_AT", Calendar.getInstance(LOCAL_DEFAULT).time.time)
        Hawk.put(key, value)
    }

    override suspend fun get(key: String): T? {
        Timber.d("Get cache = $key")
        val value: T? = Hawk.get<T>(key)
        val createAt = Hawk.get("${key}_$CREATE_AT", 0L)
        val deference = Calendar.getInstance(LOCAL_DEFAULT).time.time - (createAt ?: 0L)
        return if (deference < lifeTimeMs) {
            value
        } else {
            null
        }
    }

    override suspend fun clear(key: String) {
        Timber.d("clear cache = $key")
        Hawk.delete(key)
    }

    override suspend fun clearAll() {
        Timber.d("Clear all")
        Hawk.deleteAll()
    }

    companion object {
        const val CREATE_AT = "create_at"

        const val DEFAULT_LIFE_TIME = 60L * 60L * 1000L
    }
}
