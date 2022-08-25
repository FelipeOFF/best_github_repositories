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
    const val LIFECYCLE_VERSION = "2.5.1"
    const val PAGING_VERSION = "3.1.1"

    const val COROUTINES_VERSION = "1.3.9"
    const val COROUTINES_ANDROID_VERSION = "1.3.9"
    const val COROUTINES_TEST_VERSION = "1.3.9"

    const val OK_HTTP_VERSION = "4.9.0"
    const val RETROFIT_VERSION = "2.9.0"

    const val GLIDE_VERSION = "4.13.2"

    const val GSON_VERSION = "2.9.1"

    const val KOIN_VERSION = "3.2.0"

    const val JUNIT_VERSION = "4.13.2"
    const val ANDROIDX_JUNIT_VERSION = "1.1.3"
    const val ANDROIDX_TEST_RUNNER = "1.4.0"
    const val ESPRESSO_CORE_VERSION = "3.4.0"
    const val MOCKK_VERSION = "1.12.1"
    const val ANDROIDX_CORE_TESTING = "2.1.0"
    const val TEST_RULES_VERSION = "1.3.0"
    const val MOCK_WEB_SERVER_VERSION = "4.9.0"

    const val HAWK_VERSION = "2.0.1"

    const val TIMBER_VERSION = "5.0.1"
}

object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${LibVersions.KOTLIN_VERSION}"

    const val ANDROID_X_CORE = "androidx.core:core-ktx:${LibVersions.CORE_KTX_VERSION}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${LibVersions.APP_COMPAT_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${LibVersions.MATERIAL_VERSION}"

    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibVersions.COROUTINES_VERSION}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibVersions.COROUTINES_ANDROID_VERSION}"
    const val LIFECYCLE = "androidx.lifecycle:lifecycle-viewmodel:${LibVersions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibVersions.LIFECYCLE_VERSION}"
    const val PAGING = "androidx.paging:paging-runtime:${LibVersions.PAGING_VERSION}"

    // HTTP

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${LibVersions.OK_HTTP_VERSION}"
    const val OKHTTP_LOG_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${LibVersions.OK_HTTP_VERSION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibVersions.RETROFIT_VERSION}"
    const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${LibVersions.RETROFIT_VERSION}"

    // Image Loader

    const val GLIDE = "com.github.bumptech.glide:glide:${LibVersions.GLIDE_VERSION}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${LibVersions.GLIDE_VERSION}"

    // Serialization and Deserialization of JSON

    const val GSON = "com.google.code.gson:gson:${LibVersions.GSON_VERSION}"

    // Dependency Injection
    const val KOIN = "io.insert-koin:koin-core:${LibVersions.KOIN_VERSION}"
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${LibVersions.KOIN_VERSION}"

    // Storage Manager
    const val HAWK = "com.orhanobut:hawk:${LibVersions.HAWK_VERSION}"

    // Other
    const val TIMBER = "com.jakewharton.timber:timber:${LibVersions.TIMBER_VERSION}"
}

object TestDependencies {
    const val JUNIT = "junit:junit:${LibVersions.JUNIT_VERSION}"

    const val MOCKK = "io.mockk:mockk:${LibVersions.MOCKK_VERSION}"

    const val JUNIT_ANDROID_X = "androidx.test.ext:junit:${LibVersions.ANDROIDX_JUNIT_VERSION}"
    const val TEST_RUNNER = "androidx.test:runner:${LibVersions.ANDROIDX_TEST_RUNNER}"
    const val CORE_KTX_TEST = "androidx.test:core-ktx:${LibVersions.ANDROIDX_TEST_RUNNER}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${LibVersions.ESPRESSO_CORE_VERSION}"

    const val ANDROIDX_CORE_TESTING = "androidx.arch.core:core-testing:${LibVersions.ANDROIDX_CORE_TESTING}"
    const val TEST_RULES = "androidx.test:rules:${LibVersions.TEST_RULES_VERSION}"

    const val COROUTINES_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibVersions.COROUTINES_TEST_VERSION}"

    const val KOIN = "io.insert-koin:koin-test:${LibVersions.KOIN_VERSION}"

    const val OKHTTP_MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${LibVersions.MOCK_WEB_SERVER_VERSION}"
}