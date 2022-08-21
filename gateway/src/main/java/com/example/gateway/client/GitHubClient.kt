package com.example.gateway.client

import com.example.gateway.AbstractClient
import com.example.gateway.URLs
import com.example.gateway.service.GitHubService
import retrofit2.Retrofit

class GitHubClient : AbstractClient() {
    override val urls: URLs = URLs.URL_PROD

    private val client: Retrofit by getRetrofit()

    val service: GitHubService by lazy {
        client.create(GitHubService::class.java)
    }
}