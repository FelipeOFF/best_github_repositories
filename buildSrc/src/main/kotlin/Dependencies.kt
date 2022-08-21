object Sdk {
    const val MIN_SDK_VERSION = 22
    const val TARGET_SDK_VERSION = 32
    const val COMPILE_VERSION = 32
    const val APP_VERSION_CODE = 1
    const val APP_VERSION_NAME = "0.0.1" // Se voce esta em HML ou DEV leia o README.md linha 200
    const val APPLICATION_ID = "com.example.bestgithubrepositories"
}

object BuildPluginsVersion {
    const val AGP = "7.2.2"
    const val DETEKT = "1.14.1"
    const val KOTLIN = "1.7.10"
    const val KTLINT_PLUGIN = "10.3.0"
    const val KTLINT = "0.39.0"
    const val VERSIONS_PLUGIN = "0.29.0"
}

object LibVersions {
    const val KOTLIN_VERSION = "1.5.31"
    const val CORE_KTX_VERSION = "1.8.0"
    const val APP_COMPAT_VERSION = "1.5.0"
    const val MATERIAL_VERSION = "1.6.1"

    const val COROUTINES_VERSION = "1.3.9"
    const val COROUTINES_ANDROID_VERSION = "1.3.9"

    const val OK_HTTP_VERSION = "4.9.0"
    const val RETROFIT_VERSION = "2.9.0"

    const val GSON_VERSION = "2.9.1"

    const val JUNIT_VERSION = "4.13.2"
    const val ANDROIDX_JUNIT_VERSION = "1.1.3"
    const val ESPRESSO_CORE_VERSION = "3.4.0"
    const val MOCKK_VERSION = "1.12.1"
}

object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${LibVersions.KOTLIN_VERSION}"

    const val ANDROID_X_CORE = "androidx.core:core-ktx:${LibVersions.CORE_KTX_VERSION}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${LibVersions.APP_COMPAT_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${LibVersions.MATERIAL_VERSION}"

    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibVersions.COROUTINES_VERSION}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibVersions.COROUTINES_ANDROID_VERSION}"

    // HTTP

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${LibVersions.OK_HTTP_VERSION}"
    const val OKHTTP_LOG_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${LibVersions.OK_HTTP_VERSION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibVersions.RETROFIT_VERSION}"
    const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${LibVersions.RETROFIT_VERSION}"

    const val GSON = "com.google.code.gson:gson:${LibVersions.GSON_VERSION}"
}

object TestDependencies {
    const val JUNIT = "junit:junit:${LibVersions.JUNIT_VERSION}"

    const val MOCKK = "io.mockk:mockk:${LibVersions.MOCKK_VERSION}"

    const val JUNIT_ANDROID_X = "androidx.test.ext:junit:${LibVersions.ANDROIDX_JUNIT_VERSION}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${LibVersions.ESPRESSO_CORE_VERSION}"
}