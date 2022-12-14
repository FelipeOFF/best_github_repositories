plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
    id("kotlin-parcelize")
}

android {
    compileSdk = Sdk.COMPILE_VERSION

    defaultConfig {
        applicationId = Sdk.APPLICATION_ID

        minSdk = Sdk.MIN_SDK_VERSION
        targetSdk = Sdk.TARGET_SDK_VERSION

        versionCode = Sdk.APP_VERSION_CODE
        versionName = Sdk.APP_VERSION_NAME

        testInstrumentationRunner = "com.example.bestgithubrepositories.runner.MockBestGithubRepositoryRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            if (signingConfigs.names.contains("debug")) { // when creating a keystore add it here
                signingConfig = signingConfigs.getByName("debug")
            }
        }

        getByName("debug") {
            isDebuggable = true
            if (signingConfigs.names.contains("debug")) {
                signingConfig = signingConfigs.getByName("debug")
            }
        }
    }

    sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }
    dynamicFeatures += setOf(":features:home", ":features:pullrequest")
}

dependencies {
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.ANDROID_X_CORE)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.TIMBER)
    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_ANDROID)
    implementation(Dependencies.LIFECYCLE)
    implementation(Dependencies.LIFECYCLE_KTX)
    implementation(Dependencies.HAWK)

    implementation(project(":di"))
    implementation(project(":common"))

    testImplementation(TestDependencies.JUNIT)

    androidTestImplementation(project(":common"))
    androidTestImplementation(project(":util"))

    androidTestImplementation(TestDependencies.JUNIT_ANDROID_X)
    androidTestImplementation(TestDependencies.TEST_RUNNER)
    androidTestImplementation(TestDependencies.CORE_KTX_TEST)
    androidTestImplementation(TestDependencies.ESPRESSO_CORE)
    androidTestImplementation(TestDependencies.KOIN)
    androidTestImplementation(TestDependencies.OKHTTP_MOCK_WEB_SERVER)
}
