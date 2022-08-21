package com.example.model.pull.request.res


import com.google.gson.annotations.SerializedName

data class Commits(
    @SerializedName("href")
    val href: String?
)