package com.example.cache

import com.example.cache.store.CacheStore
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CoCacheTest {

    private val cacheStoreMock: CacheStore<String> = mockk()

    private val cache: Cache<String> = spyk(CoCache(cacheStoreMock))

    @Test
    fun `when requesting get from cache returns the stored value`(): Unit = runBlocking {
        // Give
        val key = "Teste"
        val wrongResult = "ResultWrong"
        val rightResult = "result"

        // When
        coEvery { cacheStoreMock.get(key) } returns rightResult

        // Then
        val result = cache.get(key) {
            delay(1000)
            wrongResult
        }

        assertEquals(result, rightResult)

        // Verify
        coVerify(exactly = 1) { cacheStoreMock.get(key) }
    }

    @Test
    fun `when requesting get from cache returns the value of the request because it doesn't exist yet`(): Unit = runBlocking {
        // Give
        val key = "Teste"
        val rightResult = "result"

        // When
        coEvery { cacheStoreMock.get(key) } returns null
        coEvery { cacheStoreMock.save(key, rightResult) } returns Unit

        // Then
        val result = cache.get(key) {
            delay(1000)
            rightResult
        }

        assertEquals(result, rightResult)

        // Verify
        coVerify(exactly = 1) { cacheStoreMock.get(key) }
        coVerify(exactly = 1) { cacheStoreMock.save(key, rightResult) }
    }

    @Test
    fun `when requesting get from cache returns the value of the request because it is forced`(): Unit = runBlocking {
        // Give
        val key = "Teste"
        val wrongResult = "ResultWrong"
        val rightResult = "result"

        // When
        coEvery { cacheStoreMock.get(key) } returns wrongResult
        coEvery { cacheStoreMock.save(key, rightResult) } returns Unit

        // Then
        val result = cache.get(key, forceLoad = true) {
            delay(1000)
            rightResult
        }

        assertEquals(result, rightResult)

        // Verify
        coVerify(exactly = 1) { cacheStoreMock.get(key) }
        coVerify(exactly = 1) { cacheStoreMock.save(key, rightResult) }
    }
}
