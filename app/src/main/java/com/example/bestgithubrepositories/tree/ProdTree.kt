package com.example.bestgithubrepositories.tree

import androidx.annotation.NonNull
import timber.log.Timber

internal class ProdTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, @NonNull message: String, t: Throwable?) {
        // here is a good option to just get the release logs and send to Firebase or any other analytics
        return
    }
}
