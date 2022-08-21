package com.example.di.gateway

import com.example.gateway.client.GitHubClient
import org.koin.dsl.module

val gatewayModule = module {
    single { GitHubClient() }
    single { get<GitHubClient>().service }
}
