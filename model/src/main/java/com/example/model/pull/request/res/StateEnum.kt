package com.example.model.pull.request.res

import com.google.gson.annotations.SerializedName

enum class StateEnum {
    @SerializedName("open")
    OPEN,
    @SerializedName("closed")
    CLOSED
}
