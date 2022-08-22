package com.example.domain.usecase

import com.example.cache.store.HawkCacheStore
import com.example.domain.ResultWrapper
import com.example.domain.util.asErrorServerOrNull
import com.example.domain.util.asSuccessValueOrNull
import com.example.model.repository.res.GitHubRepositories
import com.example.repository.GitHubRepository
import com.example.util.Const.CacheKey.GET_ALL_REPOSITORIES_CACHING
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class GetAllRepositoriesTest {

    private val repository: GitHubRepository = mockk()

    @Test
    fun `on execute UseCase GetAllRepositories giving page then return a list of repository`(): Unit = runBlocking {
        val listOfRepository: GitHubRepositories = mockk()

        val useCase = GetAllRepositories(
            repository,
            cacheStrategy = mockk<HawkCacheStore<GitHubRepositories>> {
                coEvery { this@mockk.get(GET_ALL_REPOSITORIES_CACHING) } returns listOfRepository
                coEvery {
                    this@mockk.save(
                        GET_ALL_REPOSITORIES_CACHING,
                        listOfRepository
                    )
                } returns Unit
            }
        )

        coEvery { repository.getAllRepositories(1) } returns listOfRepository

        val result = useCase(null, forceLoad = true).toList()

        assert(result[0] is ResultWrapper.Loading)
        assert(result[1] is ResultWrapper.Success)
        assert(result[2] is ResultWrapper.DismissLoading)

        assertEquals(result[1].asSuccessValueOrNull(), listOfRepository)

        coVerify(exactly = 1) { repository.getAllRepositories(1) }
    }

    @Test
    fun `on execute UseCase GetAllRepositories giving page then return a list of repository with cache`(): Unit = runBlocking {
        val listOfRepository: GitHubRepositories = mockk()
        val listOfRepositoryFromCache: GitHubRepositories = mockk()

        val useCase = GetAllRepositories(
            repository,
            cacheStrategy = mockk<HawkCacheStore<GitHubRepositories>> {
                coEvery { this@mockk.get(GET_ALL_REPOSITORIES_CACHING) } returns listOfRepositoryFromCache
                coEvery {
                    this@mockk.save(
                        GET_ALL_REPOSITORIES_CACHING,
                        listOfRepository
                    )
                } returns Unit
            }
        )

        coEvery { repository.getAllRepositories(1) } returns listOfRepository

        useCase(null).toList() // Only for put param in stack
        val result = useCase(null).toList()

        assert(result[0] is ResultWrapper.Loading)
        assert(result[1] is ResultWrapper.Success)
        assert(result[2] is ResultWrapper.DismissLoading)

        assertEquals(result[1].asSuccessValueOrNull(), listOfRepositoryFromCache)

        coVerify(exactly = 0) { repository.getAllRepositories(1) }
    }

    @Test
    fun `on execute UseCase GetAllRepositories giving page then return a error Server`(): Unit = runBlocking {
        val value = "Teste"
        val code = 401
        val exception = HttpException(Response.error<GitHubRepositories>(code, value.toResponseBody()))

        val useCase = GetAllRepositories(
            repository,
            cacheStrategy = mockk<HawkCacheStore<GitHubRepositories>> {
                coEvery { this@mockk.get(GET_ALL_REPOSITORIES_CACHING) } returns null
            }
        )

        coEvery { repository.getAllRepositories(1) } throws exception

        val result = useCase(null).toList()

        assert(result[0] is ResultWrapper.Loading)
        assert(result[1] is ResultWrapper.Error)
        assert(result[2] is ResultWrapper.DismissLoading)

        assertEquals(result[1].asErrorServerOrNull()?.cause, exception)

        coVerify(exactly = 1) { repository.getAllRepositories(1) }
    }
}