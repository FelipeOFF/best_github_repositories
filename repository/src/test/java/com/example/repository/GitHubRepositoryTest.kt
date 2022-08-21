package com.example.repository

import com.example.gateway.service.GitHubService
import com.example.model.pull.request.res.PullRequest
import com.example.model.repository.res.GitHubRepositories
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class GitHubRepositoryTest {

    private val gitHubService: GitHubService = mockk()

    private val gitHubRepository: GitHubRepository =
        GitHubRepositoryImpl(gitHubService)

    @Test
    fun `on call getAllRepositories giving a page then return a Repositories DTO with success call`(): Unit =
        runBlocking {
            val page = 25
            val gitHubRepositories: GitHubRepositories = mockk()

            coEvery { gitHubService.getRepositories(search = "language:Java", page = page) } returns gitHubRepositories

            val result = gitHubRepository.getAllRepositories(page)

            assertEquals(result, gitHubRepositories)

            coVerify(exactly = 1) { gitHubService.getRepositories(search = "language:Java", page = page) }
        }

    @Test
    fun `on call getAllRepositories giving a page then return an error HTTP`(): Unit =
        runBlocking {
            val page = 25
            val httpErrorCode = 400
            val httpMessageError = "Unauthorized error"

            val httpException = HttpException(
                mockk<Response<String>> {
                    every { code() } returns httpErrorCode
                    every { message() } returns httpMessageError
                }
            )

            coEvery { gitHubService.getRepositories(search = "language:Java", page = page) } throws httpException

            try {
                val result = gitHubRepository.getAllRepositories(page)
                assertNull(result)
            } catch (e: HttpException) {
                assertEquals(e, httpException)
            }

            coVerify(exactly = 1) { gitHubService.getRepositories(search = "language:Java", page = page) }
        }

    @Test
    fun `on call getAllPullRequestFromRepository giving a client and repository then return a list of PullRequest DTO with success call`(): Unit =
        runBlocking {
            val client = "elastic"
            val repository = "elasticsearch"

            val gitHubPullRequestsFromElastic: List<PullRequest> = listOf(mockk())

            coEvery { gitHubService.getPullRequestsFromRepository(client = client, repository = repository) } returns gitHubPullRequestsFromElastic

            val result = gitHubRepository.getAllPullRequestFromRepository(client = client, repository = repository)

            assertEquals(result.first(), gitHubPullRequestsFromElastic.first())

            coVerify(exactly = 1) { gitHubService.getPullRequestsFromRepository(client = client, repository = repository) }
        }

    @Test
    fun `on call getAllPullRequestFromRepository giving a client and repository then return an error HTTP`(): Unit =
        runBlocking {
            val client = "elastic"
            val repository = "elasticsearch"

            val httpErrorCode = 400
            val httpMessageError = "Unauthorized error"

            val httpException = HttpException(
                mockk<Response<String>> {
                    every { code() } returns httpErrorCode
                    every { message() } returns httpMessageError
                }
            )

            coEvery { gitHubService.getPullRequestsFromRepository(client = client, repository = repository) } throws httpException

            try {
                val result = gitHubRepository.getAllPullRequestFromRepository(client = client, repository = repository)
                assertNull(result)
            } catch (e: HttpException) {
                assertEquals(e, httpException)
            }

            coVerify(exactly = 1) { gitHubService.getPullRequestsFromRepository(client = client, repository = repository) }
        }
}
