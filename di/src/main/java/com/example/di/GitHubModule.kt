package com.example.di

import com.example.common.navigation.Navigation
import com.example.common.navigation.NavigationImpl
import com.example.di.domain.domainModule
import com.example.di.gateway.gatewayModule
import com.example.di.repository.repositoryModule
import org.koin.core.module.Module
import org.koin.dsl.module

val gitHubModule = module {
    single<Navigation> { NavigationImpl() }
}

val gitHubModules: List<Module> = listOf(
    gitHubModule,
    gatewayModule,
    repositoryModule,
    domainModule
)
