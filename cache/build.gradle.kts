plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
            buildConfigField("Boolean", "ENABLE_CACHE_REQUEST", "true")
        }

        getByName("debug") {
            buildConfigField("Boolean", "ENABLE_CACHE_REQUEST", "true")
        }
    }

    sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }
}

dependencies {
    implementation(Dependencies.TIMBER)
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.GSON)
    implementation(Dependencies.HAWK)

    implementation(project(":util"))

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.MOCKK)
}
