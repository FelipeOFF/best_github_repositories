package com.example.domain.usecase

import com.example.domain.AbstractUseCase
import com.example.model.repository.res.GitHubRepositories
import com.example.repository.GitHubRepository

class GetAllRepositories constructor(
    private val repository: GitHubRepository,
) : AbstractUseCase<Int?, GitHubRepositories>() {
    override suspend fun execute(param: Int?): GitHubRepositories =
        repository.getAllRepositories(param ?: 1)
}
