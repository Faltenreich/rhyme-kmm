plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization")
    id("dev.icerock.mobile.multiplatform-resources")
    id("com.google.devtools.ksp")
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                // FIXME: Does currently not work for iosArm64
                // implementation(compose.preview)
                implementation(compose.runtime)

                implementation(Dependencies.Koin.core)
                implementation(Dependencies.Koin.annotations)
                implementation(Dependencies.Kotlinx.coroutines)
                implementation(Dependencies.Kotlinx.serialization)
                implementation(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.contentNegotiation)
                implementation(Dependencies.Ktor.serialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Dependencies.Koin.test)
                implementation(Dependencies.Ktor.mock)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Koin.android)
                implementation(Dependencies.Ktor.android)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Dependencies.Koin.testJunit4)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Dependencies.Ktor.ios)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.faltenreich.rhyme"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
    // Workaround for unresolved reference on Android
    // https://github.com/icerockdev/moko-resources/issues/353
    sourceSets["main"].apply {
        assets.srcDir(File(buildDir, "generated/moko/androidMain/assets"))
        res.srcDir(File(buildDir, "generated/moko/androidMain/res"))
    }
}

dependencies {
    commonMainApi(Dependencies.Moko.resources)
    add("kspCommonMainMetadata", Dependencies.Koin.kspCompiler)
    add("kspAndroid", Dependencies.Koin.kspCompiler)
    add("kspIosX64", Dependencies.Koin.kspCompiler)
    add("kspIosSimulatorArm64", Dependencies.Koin.kspCompiler)
}

multiplatformResources {
    multiplatformResourcesPackage = "com.faltenreich.rhyme"
}