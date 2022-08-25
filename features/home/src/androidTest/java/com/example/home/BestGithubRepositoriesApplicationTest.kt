package com.example.home

import com.example.bestgithubrepositories.BestGithubRepositoriesApplication
import com.example.gateway.client.MockClient
import org.koin.dsl.module

class BestGithubRepositoriesApplicationTest : BestGithubRepositoriesApplication() {
    override val allowOverride: Boolean = true

    private val gatewayModuleMock = module {
        single { MockClient() }
        single { get<MockClient>().service }
    }

    override fun onCreate() {
        super.onCreate()
        koinApplication.modules(gatewayModuleMock)
    }
}
