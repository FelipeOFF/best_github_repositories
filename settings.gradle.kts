pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

rootProject.name = "Best GitHub Repositories"

include(
    ":app",
    ":gateway",
    ":util",
    ":model",
    ":cache",
    ":repository",
    ":di",
    ":domain",
    ":common",
    ":features:home",
    ":features:pullrequest",
)
