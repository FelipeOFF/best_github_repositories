package com.example.model.repository.res

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repository(
    @SerializedName("description")
    val description: String?,
    @SerializedName("forks")
    val forks: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("owner")
    val owner: Owner?,
    @SerializedName("stargazers_count")
    val stargazersCount: Int?,
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Repository

        if (description != other.description) return false
        if (forks != other.forks) return false
        if (name != other.name) return false
        if (owner != other.owner) return false
        if (stargazersCount != other.stargazersCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = description?.hashCode() ?: 0
        result = 31 * result + (forks ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (owner?.hashCode() ?: 0)
        result = 31 * result + (stargazersCount ?: 0)
        return result
    }
}
