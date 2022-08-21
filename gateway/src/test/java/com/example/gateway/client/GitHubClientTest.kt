package com.example.gateway.client

import com.example.gateway.service.GitHubService
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import retrofit2.Retrofit

class GitHubClientTest {

    private val retrofitMock: Retrofit = mockk()

    @Test
    fun `when purchasing the retrofit client, set the correct github URL`() {
        // Give
        val gitHubClient = spyk(GitHubClient())

        // When
        every { gitHubClient.getRetrofit() } returns lazy { retrofitMock }

        // Then
        val gitHubService: GitHubService = gitHubClient.service

        assertNotNull(gitHubService)

        // Verify
        verify { gitHubClient.service }
    }

}