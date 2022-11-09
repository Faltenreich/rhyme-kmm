package com.faltenreich.rhyme.networking

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*

class KtorClient(engine: HttpClientEngine): NetworkingClient {

    private val client = HttpClient(engine) {
        install(ContentNegotiation) {
            json()
        }
    }

    override suspend fun request(url: String): String {
        val response = client.get(url)
        return response.bodyAsText()
    }
}