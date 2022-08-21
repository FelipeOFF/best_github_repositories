package com.example.di.domain

import com.example.domain.usecase.GetAllPullRequestFromRepository
import com.example.domain.usecase.GetAllRepositories
import org.koin.dsl.module

val domainModule = module {
    single { GetAllPullRequestFromRepository(get()) }
    single { GetAllRepositories(get()) }
}
