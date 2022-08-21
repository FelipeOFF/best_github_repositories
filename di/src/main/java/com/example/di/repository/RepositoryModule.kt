package com.example.di.repository

import com.example.repository.GitHubRepository
import com.example.repository.GitHubRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GitHubRepository> { GitHubRepositoryImpl(get()) }
}
