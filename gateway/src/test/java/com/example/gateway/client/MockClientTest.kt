package com.example.gateway.client

import com.example.gateway.service.GitHubService
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import retrofit2.Retrofit

class MockClientTest {

    private val retrofitMock: Retrofit = mockk()

    @Test
    fun `when purchasing the retrofit client, set the correct mock URL`() {
        // Give
        val mockClient = spyk(MockClient())

        // When
        every { mockClient.getRetrofit() } returns lazy { retrofitMock }

        // Then
        val gitHubService: GitHubService = mockClient.service

        assertNotNull(gitHubService)

        // Verify
        verify(exactly = 1) { mockClient.service }
    }

}