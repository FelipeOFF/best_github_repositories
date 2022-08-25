package com.example.common.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.util.Const
import com.example.util.loadClassOrNull

class NavigationImpl : Navigation {
    override fun navigateToPullRequestActivity(context: Context, bundle: Bundle?) {
        loadClassOrNull<Activity>(Const.Activity.PULL_REQUEST_ACTIVITY)?.also { goToActivity ->
            context.startActivity(
                Intent(context, goToActivity).apply {
                    bundle?.let {
                        putExtras(it)
                    }
                }
            )
        }
    }
}