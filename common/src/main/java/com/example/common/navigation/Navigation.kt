package com.example.common.navigation

import android.content.Context
import android.os.Bundle

interface Navigation {
    fun navigateToPullRequestActivity(context: Context, bundle: Bundle?)
}