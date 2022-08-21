package com.example.model.pull.request.res

import com.google.gson.annotations.SerializedName

data class Label(
    @SerializedName("color")
    val color: String?,
    @SerializedName("default")
    val default: Boolean?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("url")
    val url: String?
)
