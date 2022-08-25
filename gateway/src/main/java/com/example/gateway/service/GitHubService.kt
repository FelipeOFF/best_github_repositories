package com.example.gateway.service

import com.example.model.pull.request.res.PullRequest
import com.example.model.repository.res.GitHubRepositories
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {

    @GET("/search/repositories")
    suspend fun getRepositories(
        @Query("q") search: String,
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int = 1,
    ): GitHubRepositories

    @GET("/repos/{client}/{repository}/pulls")
    suspend fun getPullRequestsFromRepository(
        @Path("client") client: String,
        @Path("repository") repository: String,
    ): List<PullRequest>
}
