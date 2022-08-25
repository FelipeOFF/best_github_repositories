package com.example.model.repository.res

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    @SerializedName("login")
    val login: String?, // used
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Owner

        if (login != other.login) return false

        return true
    }

    override fun hashCode(): Int {
        return login?.hashCode() ?: 0
    }
}
