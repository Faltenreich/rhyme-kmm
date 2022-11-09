package com.faltenreich.rhyme.serialization

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

@OptIn(InternalSerializationApi::class)
class KotlinxSerialization: JsonSerialization {

    @PublishedApi internal val parser = Json.Default

    override fun <T : Any> encode(data: T, clazz: KClass<T>): String {
        return parser.encodeToString(clazz.serializer(), data)
    }

    override fun <T : Any> decode(json: String, clazz: KClass<T>): T {
        return parser.decodeFromString(clazz.serializer(), json)
    }
}