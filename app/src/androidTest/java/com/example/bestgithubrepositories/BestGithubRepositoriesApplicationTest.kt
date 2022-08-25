package com.example.bestgithubrepositories

import com.example.di.gateway.gatewayModuleMock

class BestGithubRepositoriesApplicationTest : BestGithubRepositoriesApplication() {
    override val allowOverride: Boolean = true

    override fun onCreate() {
        super.onCreate()
        koinApplication.modules(gatewayModuleMock)
    }
}
