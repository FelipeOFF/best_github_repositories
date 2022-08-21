package com.example.bestgithubrepositories

import android.app.Application
import com.example.bestgithubrepositories.tree.ProdTree
import com.example.di.gitHubModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import timber.log.Timber

open class BestGithubRepositoriesApplication : Application() {

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

        koinApplication
    }

    protected val koinApplication: KoinApplication by lazy {
        startKoin {
            androidContext(this@BestGithubRepositoriesApplication)
            androidFileProperties()
            koin.loadModules(gitHubModules)
        }
    }
}
