package com.example.bestgithubrepositories

import android.app.Application
import com.example.bestgithubrepositories.tree.ProdTree
import com.example.di.gitHubModules
import com.orhanobut.hawk.Hawk
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

        Hawk.init(applicationContext).build()

        koinApplication
    }

    open val allowOverride: Boolean = false

    protected val koinApplication: KoinApplication by lazy {
        startKoin {
            allowOverride(allowOverride)
            androidContext(this@BestGithubRepositoriesApplication)
            androidFileProperties()
            koin.loadModules(gitHubModules)
        }
    }
}
