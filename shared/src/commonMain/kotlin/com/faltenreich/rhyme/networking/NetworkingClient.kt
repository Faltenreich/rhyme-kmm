package com.faltenreich.rhyme.networking

interface NetworkingClient {

    suspend fun request(): String
}