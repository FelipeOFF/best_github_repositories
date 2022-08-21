package com.example.gateway

import com.example.gateway.mock.AbstractClientClientMock
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AbstractClientTest {

    private val httpClientBuilder: OkHttpClient.Builder = mockk()
    private val retrofitClientBuilder: Retrofit.Builder = mockk()
    private val httpLoggingInterceptor: HttpLoggingInterceptor = mockk()
    private val retrofitMock: Retrofit = mockk()
    private val okHttpClientMock: OkHttpClient = mockk()
    private val urls = URLs.URL_PROD

    @Before
    fun setup() {
        // When defaults
        every { httpClientBuilder.addInterceptor(httpLoggingInterceptor) } returns httpClientBuilder
        every { httpClientBuilder.connectTimeout(AbstractClient.OKHTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS) } returns httpClientBuilder
        every { httpClientBuilder.readTimeout(AbstractClient.OKHTTP_READ_TIMEOUT, TimeUnit.SECONDS) } returns httpClientBuilder
        every { httpClientBuilder.writeTimeout(AbstractClient.OKHTTP_WRITE_TIMEOUT, TimeUnit.SECONDS) } returns httpClientBuilder
        every { httpClientBuilder.build() } returns okHttpClientMock
        every { retrofitClientBuilder.client(okHttpClientMock) } returns retrofitClientBuilder
        every { retrofitClientBuilder.baseUrl(urls.url) } returns retrofitClientBuilder
        every { retrofitClientBuilder.addConverterFactory(any<GsonConverterFactory>()) } returns retrofitClientBuilder
        every { retrofitClientBuilder.build() } returns retrofitMock
    }

    @Test
    fun `when calling getRetrofit and the retrofit instance is created along with OKHttpClient with http log`() {
        // Given
        val abstractGateway = spyk(
            AbstractClientClientMock(
            urls = urls,
            httpClientBuilder = httpClientBuilder,
            retrofitClientBuilder = retrofitClientBuilder,
            httpLoggingInterceptor = httpLoggingInterceptor,
            enableHttpLogging = true
        )
        )

        // When
        every { httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY) } returns httpLoggingInterceptor

        val retrofitLazy = abstractGateway.getRetrofit()

        // Then
        assertEquals(retrofitLazy.value, retrofitMock)

        // Verify
        verify(exactly = 1) { httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY) }
        verify(exactly = 1) { httpClientBuilder.addInterceptor(httpLoggingInterceptor) }
        verify(exactly = 1) { httpClientBuilder.connectTimeout(AbstractClient.OKHTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS) }
        verify(exactly = 1) { httpClientBuilder.readTimeout(AbstractClient.OKHTTP_READ_TIMEOUT, TimeUnit.SECONDS) }
        verify(exactly = 1) { httpClientBuilder.writeTimeout(AbstractClient.OKHTTP_WRITE_TIMEOUT, TimeUnit.SECONDS) }
        verify(exactly = 1) { retrofitClientBuilder.client(okHttpClientMock) }
        verify(exactly = 1) { retrofitClientBuilder.baseUrl(urls.url) }
        verify(exactly = 1) { retrofitClientBuilder.addConverterFactory(any()) }
        verify(exactly = 1) { retrofitClientBuilder.build() }
    }

    @Test
    fun `when calling getRetrofit and the retrofit instance is created along with OKHttpClient without http log`() {
        // Given
        val abstractGateway = spyk(
            AbstractClientClientMock(
            urls = urls,
            httpClientBuilder = httpClientBuilder,
            retrofitClientBuilder = retrofitClientBuilder,
            httpLoggingInterceptor = httpLoggingInterceptor,
            enableHttpLogging = false
        )
        )

        // When
        every { httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE) } returns httpLoggingInterceptor

        val retrofitLazy = abstractGateway.getRetrofit()

        // Then
        assertEquals(retrofitLazy.value, retrofitMock)

        // Verify
        verify(exactly = 1) { httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE) }
        verify(exactly = 1) { httpClientBuilder.addInterceptor(httpLoggingInterceptor) }
        verify(exactly = 1) { httpClientBuilder.connectTimeout(AbstractClient.OKHTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS) }
        verify(exactly = 1) { httpClientBuilder.readTimeout(AbstractClient.OKHTTP_READ_TIMEOUT, TimeUnit.SECONDS) }
        verify(exactly = 1) { httpClientBuilder.writeTimeout(AbstractClient.OKHTTP_WRITE_TIMEOUT, TimeUnit.SECONDS) }
        verify(exactly = 1) { retrofitClientBuilder.client(okHttpClientMock) }
        verify(exactly = 1) { retrofitClientBuilder.baseUrl(urls.url) }
        verify(exactly = 1) { retrofitClientBuilder.addConverterFactory(any()) }
        verify(exactly = 1) { retrofitClientBuilder.build() }
    }

}