package com.faltenreich.rhyme.serialization

import kotlin.reflect.KClass

interface JsonSerialization {

    fun <T: Any> encode(data: T, clazz: KClass<T>): String
    fun <T: Any> decode(json: String, clazz: KClass<T>): T
}

inline fun <reified T: Any> JsonSerialization.encode(data: T): String {
    return encode(data, T::class)
}

inline fun <reified T: Any> JsonSerialization.decode(json: String): T {
    return decode(json, T::class)
}