package com.example.model.pull.request.res


import com.google.gson.annotations.SerializedName

data class ReviewComment(
    @SerializedName("href")
    val href: String?
)