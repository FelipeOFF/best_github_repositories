package com.example.domain.usecase

import com.example.cache.store.HawkCacheStore
import com.example.domain.ResultWrapper
import com.example.domain.util.asErrorServerOrNull
import com.example.domain.util.asSuccessValueOrNull
import com.example.model.pull.request.req.GetPullRequestReq
import com.example.model.pull.request.res.PullRequest
import com.example.repository.GitHubRepository
import com.example.util.Const
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

class GetAllPullRequestFromRepositoryTest {

    private val repository: GitHubRepository = mockk()

    @Test
    fun `Execute GetAllPullRequestFromRepository giving an parameters then return a list of pull requests`(): Unit =
        runBlocking {
            val client = "elastic"
            val repositoryName = "elasticsearch"

            val listOfPullRequests: List<PullRequest> = listOf(mockk())

            val useCase = GetAllPullRequestFromRepository(
                repository,
                cacheStrategy = mockk<HawkCacheStore<List<PullRequest>>> {
                    coEvery { this@mockk.get(Const.CacheKey.GET_ALL_PULL_REQUESTS_CACHING) } returns listOfPullRequests
                    coEvery {
                        this@mockk.save(
                            Const.CacheKey.GET_ALL_PULL_REQUESTS_CACHING,
                            listOfPullRequests
                        )
                    } returns Unit
                }
            )

            coEvery { repository.getAllPullRequestFromRepository(client, repositoryName) } returns listOfPullRequests

            val result = useCase(GetPullRequestReq(client, repositoryName)).toList()

            assert(result[0] is ResultWrapper.Loading)
            assert(result[1] is ResultWrapper.Success)
            assert(result[2] is ResultWrapper.DismissLoading)

            assertEquals(result[1].asSuccessValueOrNull()?.first(), listOfPullRequests.first())

            coVerify(exactly = 1) { repository.getAllPullRequestFromRepository(client, repositoryName) }
        }

    @Test
    fun `Execute GetAllPullRequestFromRepository giving an parameters then return a list of pull requests with cache`(): Unit =
        runBlocking {
            val client = "elastic"
            val repositoryName = "elasticsearch"

            val listOfPullRequests: List<PullRequest> = listOf(mockk())
            val listOfPullRequestsFromCache: List<PullRequest> = listOf(mockk())

            val useCase = GetAllPullRequestFromRepository(
                repository,
                cacheStrategy = mockk<HawkCacheStore<List<PullRequest>>> {
                    coEvery { this@mockk.get(Const.CacheKey.GET_ALL_PULL_REQUESTS_CACHING) } returns listOfPullRequestsFromCache
                    coEvery {
                        this@mockk.save(
                            Const.CacheKey.GET_ALL_PULL_REQUESTS_CACHING,
                            listOfPullRequests
                        )
                    } returns Unit
                }
            )

            coEvery { repository.getAllPullRequestFromRepository(client, repositoryName) } returns listOfPullRequests

            useCase(GetPullRequestReq(client, repositoryName)).toList() // Only for put param in stack
            val result = useCase(GetPullRequestReq(client, repositoryName)).toList()

            assert(result[0] is ResultWrapper.Loading)
            assert(result[1] is ResultWrapper.Success)
            assert(result[2] is ResultWrapper.DismissLoading)

            assertEquals(result[1].asSuccessValueOrNull()?.first(), listOfPullRequestsFromCache.first())

            coVerify(exactly = 1) { repository.getAllPullRequestFromRepository(client, repositoryName) }
        }

    @Test
    fun `Execute GetAllPullRequestFromRepository giving an parameters then return a http error`(): Unit =
        runBlocking {
            val client = "elastic"
            val repositoryName = "elasticsearch"

            val value = "Teste"
            val code = 401
            val exception = HttpException(Response.error<List<PullRequest>>(code, value.toResponseBody()))

            val useCase = GetAllPullRequestFromRepository(
                repository,
                cacheStrategy = mockk<HawkCacheStore<List<PullRequest>>> {
                    coEvery { this@mockk.get(Const.CacheKey.GET_ALL_PULL_REQUESTS_CACHING) } returns null
                }
            )

            coEvery { repository.getAllPullRequestFromRepository(client, repositoryName) } throws exception

            val result = useCase(GetPullRequestReq(client, repositoryName)).toList()

            assert(result[0] is ResultWrapper.Loading)
            assert(result[1] is ResultWrapper.Error)
            assert(result[2] is ResultWrapper.DismissLoading)

            assertEquals(result[1].asErrorServerOrNull()?.cause, exception)

            coVerify(exactly = 1) { repository.getAllPullRequestFromRepository(client, repositoryName) }
        }
}