package com.example.model.pull.request.req

import com.google.gson.annotations.SerializedName

data class GetPullRequestReq(
    @SerializedName("client")
    val client: String,
    @SerializedName("repository")
    val repository: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GetPullRequestReq

        if (client != other.client) return false
        if (repository != other.repository) return false

        return true
    }

    override fun hashCode(): Int {
        var result = client.hashCode()
        result = 31 * result + repository.hashCode()
        return result
    }
}
