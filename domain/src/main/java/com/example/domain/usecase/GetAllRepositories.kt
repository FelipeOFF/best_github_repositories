package com.example.domain.usecase

import com.example.cache.CoCache
import com.example.cache.store.CacheStore
import com.example.cache.store.HawkCacheStore
import com.example.domain.AbstractUseCase
import com.example.model.repository.res.GitHubRepositories
import com.example.repository.GitHubRepository
import com.example.util.Const.CacheKey.GET_ALL_REPOSITORIES_CACHING

class GetAllRepositories constructor(
    private val repository: GitHubRepository,
    cacheStrategy: CacheStore<GitHubRepositories> = HawkCacheStore(),
) : AbstractUseCase<Int?, GitHubRepositories>(cache = CoCache(cacheStrategy), key = GET_ALL_REPOSITORIES_CACHING) {
    override suspend fun execute(param: Int?): GitHubRepositories =
        repository.getAllRepositories(param ?: 1)
}
