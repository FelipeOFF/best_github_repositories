plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
}

android {
    compileSdk = Sdk.COMPILE_VERSION
    defaultConfig {
        minSdk = Sdk.MIN_SDK_VERSION
        targetSdk = Sdk.TARGET_SDK_VERSION
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
        }

        getByName("debug") {
        }
    }

    sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }
}

dependencies {
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_ANDROID)

    implementation(project(":model"))
    implementation(project(":gateway"))
    implementation(project(":repository"))
    implementation(project(":domain"))
    implementation(project(":cache"))
}
