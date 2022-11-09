package com.faltenreich.rhyme.networking

interface NetworkingClient {

    suspend fun request(url: String): String
}