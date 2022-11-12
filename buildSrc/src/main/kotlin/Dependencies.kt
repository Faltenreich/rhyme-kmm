object Versions {

    const val androidCompose = "1.6.1"
    const val androidGradle = "7.3.1"
    const val compose = "1.2.1"
    const val coroutines = "1.6.4"
    const val kotlin = "1.7.20"
    const val ktor = "2.1.3"
    const val moko = "0.20.1"
    const val serialization = "1.4.1"
}

object Dependencies {

    object Androidx {

        const val activityCompose = "androidx.activity:activity-compose:${Versions.androidCompose}"
    }

    object Kotlinx {

        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    }

    object Ktor {

        const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val cio = "io.ktor:ktor-client-cio:${Versions.ktor}"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val darwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
        const val okHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        const val mock = "io.ktor:ktor-client-mock:${Versions.ktor}"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    }

    object Moko {

        const val resourcesPlugin = "dev.icerock.moko:resources-generator:${Versions.moko}"
        const val resources = "dev.icerock.moko:resources:${Versions.moko}"
    }
}