plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
}

android {
    compileSdk = Sdk.COMPILE_VERSION

    defaultConfig {
        applicationId = Sdk.APPLICATION_ID

        minSdk = Sdk.MIN_SDK_VERSION
        targetSdk = Sdk.TARGET_SDK_VERSION

        versionCode = Sdk.APP_VERSION_CODE
        versionName = Sdk.APP_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }
}

dependencies {

    implementation(Dependencies.ANDROID_X_CORE)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)

    testImplementation(TestDependencies.JUNIT)

    androidTestImplementation(TestDependencies.JUNIT_ANDROID_X)
    androidTestImplementation(TestDependencies.ESPRESSO_CORE)
}