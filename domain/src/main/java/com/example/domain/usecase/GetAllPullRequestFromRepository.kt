package com.example.domain.usecase

import com.example.cache.CoCache
import com.example.cache.store.CacheStore
import com.example.cache.store.HawkCacheStore
import com.example.domain.AbstractUseCase
import com.example.model.pull.request.req.GetPullRequestReq
import com.example.model.pull.request.res.PullRequest
import com.example.repository.GitHubRepository
import com.example.util.Const.CacheKey.GET_ALL_PULL_REQUESTS_CACHING

class GetAllPullRequestFromRepository constructor(
    private val repository: GitHubRepository,
    cacheStrategy: CacheStore<List<PullRequest>> = HawkCacheStore()
) : AbstractUseCase<GetPullRequestReq, List<PullRequest>>(
    cache = CoCache(cacheStrategy),
    key = GET_ALL_PULL_REQUESTS_CACHING
) {
    override suspend fun execute(param: GetPullRequestReq): List<PullRequest> =
        repository.getAllPullRequestFromRepository(client = param.client, repository = param.repository)
}
