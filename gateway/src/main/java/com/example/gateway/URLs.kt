package com.example.gateway

enum class URLs(val url: String) {
    URL_PROD("https://api.github.com/"),
    URL_MOCK("http://localhost:8080")
}
