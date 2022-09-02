# Best GitHub Repositories App

![Language](https://img.shields.io/github/languages/top/cortinico/kotlin-android-template?color=blue&logo=kotlin) <img src="https://img.shields.io/badge/instrumental%20test-100%25-green"> <img src="https://img.shields.io/badge/-Unit%20Tests-green">

This app lets user know which repository is most popular of java language.

This project is build with static analysis and continuous integration already in place.

## Features 🎨

- Clean Architecture.
- MVVM Architecture in Module.
- 100% Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
- Material Design Components
- Kotlin Static Analysis via `ktlint` and `detekt`.
- Kotlin Coroutines
- Kotlin Flow
- Retrofit
- Logs with Timber
- ViewBinding
- Integration Test
- Unitary test

This project is using [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup the build.

Dependencies are centralized inside the [Dependencies.kt](buildSrc/src/main/kotlin/Dependencies.kt) file in the `buildSrc` folder. This provides convenient auto-completion when writing your gradle files.

## Static Analysis 🔍

This project is using [**ktlint**](https://github.com/pinterest/ktlint) with the [ktlint-gradle](https://github.com/jlleitschuh/ktlint-gradle) plugin to format your code. To reformat all the source code as well as the buildscript you can run the `ktlintFormat` gradle task.

This project is also using [**detekt**](https://github.com/detekt/detekt) to analyze the source code, with the configuration that is stored in the [detekt.yml](config/detekt/detekt.yml) file (the file has been generated with the `detektGenerateConfig` task).

## CI ⚙️

This project is using [**GitHub Actions**](https://github.com/FelipeOFF/best_github_repositories/actions) as CI.

There are currently the following workflows available:
- [Pre Merge Checks](.github/workflows/pre-merge.yaml) - Will run the `build`, `check` tasks. 

------------------------------------------------------------------------------------------------------------------------

This is based in a repository Android Template:

https://github.com/cortinico/kotlin-android-template