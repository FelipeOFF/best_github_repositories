package com.example.model.pull.request.res

import com.google.gson.annotations.SerializedName

data class PullRequest(
    @SerializedName("body")
    val body: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("user")
    val user: User?,
    @SerializedName("state")
    val state: StateEnum?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PullRequest

        if (body != other.body) return false
        if (htmlUrl != other.htmlUrl) return false
        if (title != other.title) return false
        if (user != other.user) return false
        if (state != other.state) return false

        return true
    }

    override fun hashCode(): Int {
        var result = body?.hashCode() ?: 0
        result = 31 * result + (htmlUrl?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (user?.hashCode() ?: 0)
        result = 31 * result + (state?.hashCode() ?: 0)
        return result
    }
}
