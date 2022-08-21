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
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.RETROFIT)

    implementation(project(":repository"))
    implementation(project(":model"))
    implementation(project(":cache"))
    implementation(project(":util"))

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.MOCKK)
}
