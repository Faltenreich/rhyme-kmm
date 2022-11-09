plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.faltenreich.rhyme"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.faltenreich.rhyme"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0-alpha01"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    packagingOptions.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.activity:activity-compose:1.6.1")
}