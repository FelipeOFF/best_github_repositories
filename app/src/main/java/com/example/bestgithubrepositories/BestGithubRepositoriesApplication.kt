package com.example.bestgithubrepositories

import android.app.Application
import com.example.bestgithubrepositories.tree.ProdTree
import timber.log.Timber

class BestGithubRepositoriesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupLibraries()
    }

    private fun setupLibraries() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ProdTree())
        }
    }
}
