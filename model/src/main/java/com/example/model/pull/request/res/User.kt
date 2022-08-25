package com.example.model.pull.request.res

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("login")
    val login: String?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (avatarUrl != other.avatarUrl) return false
        if (login != other.login) return false

        return true
    }

    override fun hashCode(): Int {
        var result = avatarUrl?.hashCode() ?: 0
        result = 31 * result + (login?.hashCode() ?: 0)
        return result
    }
}