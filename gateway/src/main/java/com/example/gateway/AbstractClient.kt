package com.example.gateway

import com.example.util.OkHttpClientBuilder
import com.example.util.RetrofitBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class AbstractClient {
    protected abstract val urls: URLs

    protected open val enableHttpLogging: Boolean = true

    fun getRetrofit(
        customConfigBuilderOkHttp: OkHttpClientBuilder = { this },
        customConfigBuilderRetrofit: RetrofitBuilder = { this }
    ): Lazy<Retrofit> = lazy {
        getRetrofitClientBuilder().apply {
            client(makeOkHttpClient(customConfigBuilderOkHttp))
            baseUrl(urls.url)
            makeConverterFactory()
        }.customConfigBuilderRetrofit().build()
    }

    private fun makeOkHttpClient(
        customConfigBuilderOkHttp: OkHttpClientBuilder = { this }
    ): OkHttpClient =
        getHttpClientBuilder()
            .customConfigBuilderOkHttp()
            .makeShowHttpLogging()
            .setTimeout()
            .build()

    protected open fun getHttpClientBuilder(): OkHttpClient.Builder =
        OkHttpClient.Builder()

    protected open fun getRetrofitClientBuilder(): Retrofit.Builder =
        Retrofit.Builder()

    protected open val httpLoggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor()
    }

    private fun Retrofit.Builder.makeConverterFactory() =
        addConverterFactory(GsonConverterFactory.create())

    private fun OkHttpClient.Builder.setTimeout(): OkHttpClient.Builder =
        connectTimeout(OKHTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OKHTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(OKHTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)

    private fun OkHttpClient.Builder.makeShowHttpLogging(): OkHttpClient.Builder =
        addInterceptor(
            httpLoggingInterceptor.setLevel(
                if (BuildConfig.SHOW_HTTP_LOGGIN && enableHttpLogging) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
        )

    companion object {
        const val OKHTTP_CONNECT_TIMEOUT = 60L
        const val OKHTTP_READ_TIMEOUT = 60L
        const val OKHTTP_WRITE_TIMEOUT = 60L
    }
}