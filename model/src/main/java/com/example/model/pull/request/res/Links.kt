package com.example.model.pull.request.res

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("comments")
    val comments: Comments?,
    @SerializedName("commits")
    val commits: Commits?,
    @SerializedName("html")
    val html: Html?,
    @SerializedName("issue")
    val issue: Issue?,
    @SerializedName("review_comment")
    val reviewComment: ReviewComment?,
    @SerializedName("review_comments")
    val reviewComments: ReviewComments?,
    @SerializedName("self")
    val self: Self?,
    @SerializedName("statuses")
    val statuses: Statuses?
)
