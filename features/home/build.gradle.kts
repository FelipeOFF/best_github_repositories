plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = Sdk.COMPILE_VERSION

    defaultConfig {
        minSdk = Sdk.MIN_SDK_VERSION
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
    implementation(Dependencies.ANDROID_X_CORE)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_ANDROID)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.LIFECYCLE)
    implementation(Dependencies.LIFECYCLE_KTX)
    implementation(Dependencies.TIMBER)

    implementation(project(":app"))
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(project(":model"))
    implementation(project(":util"))

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.MOCKK)
}
