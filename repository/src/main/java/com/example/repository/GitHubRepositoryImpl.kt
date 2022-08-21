package com.example.repository

import com.example.gateway.service.GitHubService
import com.example.model.pull.request.res.PullRequest
import com.example.model.repository.res.GitHubRepositories

class GitHubRepositoryImpl constructor(
    private val gitHubService: GitHubService,
) : GitHubRepository {

    override suspend fun getAllRepositories(page: Int): GitHubRepositories =
        gitHubService.getRepositories(search = "language:Java", page = page)

    override suspend fun getAllPullRequestFromRepository(client: String, repository: String): List<PullRequest> =
        gitHubService.getPullRequestsFromRepository(client, repository)
}
