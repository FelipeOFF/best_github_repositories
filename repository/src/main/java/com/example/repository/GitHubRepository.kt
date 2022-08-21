package com.example.repository

import com.example.model.pull.request.res.PullRequest
import com.example.model.repository.res.GitHubRepositories

interface GitHubRepository {
    suspend fun getAllRepositories(page: Int = 1): GitHubRepositories
    suspend fun getAllPullRequestFromRepository(client: String, repository: String): List<PullRequest>
}
