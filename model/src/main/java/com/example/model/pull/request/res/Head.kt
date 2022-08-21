package com.example.model.pull.request.res

import com.google.gson.annotations.SerializedName

data class Head(
    @SerializedName("label")
    val label: String?,
    @SerializedName("ref")
    val ref: String?,
    @SerializedName("repo")
    val repo: Repo?,
    @SerializedName("sha")
    val sha: String?,
    @SerializedName("user")
    val user: User?
)
