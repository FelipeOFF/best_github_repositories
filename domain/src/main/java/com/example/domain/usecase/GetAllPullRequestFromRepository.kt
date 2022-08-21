package com.example.domain.usecase

import com.example.domain.AbstractUseCase
import com.example.model.pull.request.req.GetPullRequestReq
import com.example.model.pull.request.res.PullRequest
import com.example.repository.GitHubRepository

class GetAllPullRequestFromRepository constructor(
    private val repository: GitHubRepository
) : AbstractUseCase<GetPullRequestReq, List<PullRequest>>() {
    override suspend fun execute(param: GetPullRequestReq): List<PullRequest> =
        repository.getAllPullRequestFromRepository(client = param.client, repository = param.repository)
}
