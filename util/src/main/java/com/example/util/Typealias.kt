package com.example.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit

typealias OkHttpClientBuilder = OkHttpClient.Builder.() -> OkHttpClient.Builder
typealias RetrofitBuilder = Retrofit.Builder.() -> Retrofit.Builder