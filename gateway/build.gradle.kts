plugins {
    id("com.android.library")
    kotlin("android")
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
            buildConfigField("Boolean", "SHOW_HTTP_LOGGIN", "false")
        }

        getByName("debug") {
            buildConfigField("Boolean", "SHOW_HTTP_LOGGIN", "true")
        }
    }

    sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }
}

dependencies {
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.OKHTTP_LOG_INTERCEPTOR)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON_CONVERTER)

    implementation(project(":util"))
    implementation(project(":model"))

    testImplementation(TestDependencies.JUNIT)
}
