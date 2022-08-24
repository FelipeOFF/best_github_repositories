package com.example.model.repository.res

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubRepositories(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean?,
    @SerializedName("items")
    val items: List<Repository>?,
    @SerializedName("total_count")
    val totalCount: Int?
) : Parcelable
