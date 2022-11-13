package com.faltenreich.rhyme.networking

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class KtorClientTest {

    @Test
    fun `sends requests`() = runBlocking {
        val json = """{"ip":"127.0.0.1"}"""
        val mockEngine = MockEngine {
            respond(content = ByteReadChannel(json))
        }
        val httpClient = HttpClient(mockEngine)
        val client = KtorClient(httpClient)
        assertEquals(json, client.request(""))
    }
}