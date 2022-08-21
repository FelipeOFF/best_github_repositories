package com.example.model.repository.res


import com.google.gson.annotations.SerializedName

data class GitHubRepositories(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean?,
    @SerializedName("items")
    val items: List<Repository>?,
    @SerializedName("total_count")
    val totalCount: Int?
)