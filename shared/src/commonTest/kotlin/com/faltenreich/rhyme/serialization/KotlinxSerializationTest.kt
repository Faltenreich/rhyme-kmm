package com.faltenreich.rhyme.serialization

import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinxSerializationTest {

    private val serialization = KotlinxSerialization()
    private val data = Data(property = "value")
    private val json = "{\"property\":\"value\"}"

    @Test
    fun `encodes data to json`() {
        assertEquals(json, serialization.encode(data))
    }

    @Test
    fun `decodes json to data`() {
        assertEquals(data, serialization.decode(json))
    }
}

@Serializable
data class Data(val property: String)