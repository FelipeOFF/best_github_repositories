package com.example.model.pull.request.req

import com.google.gson.annotations.SerializedName

data class GetPullRequestReq(
    @SerializedName("client")
    val client: String,
    @SerializedName("repository")
    val repository: String
)
