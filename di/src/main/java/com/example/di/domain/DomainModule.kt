package com.example.di.domain

import com.example.domain.usecase.GetAllPullRequestFromRepositoryUseCase
import com.example.domain.usecase.GetAllRepositoriesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetAllPullRequestFromRepositoryUseCase(get()) }
    single { GetAllRepositoriesUseCase(get()) }
}
