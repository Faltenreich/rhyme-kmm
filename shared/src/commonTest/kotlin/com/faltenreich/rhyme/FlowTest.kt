package com.faltenreich.rhyme

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class FlowTest {

    @Test
    fun `test something`() = runBlocking {
        val flow = flow {
            (0 until 100).forEach {
                delay(10)
                emit(it)
                println("Counting: $it")
            }
        }.flowOn(Dispatchers.Default)
        flow
            .map { it * 20 }
            .collect { value ->
            assertTrue(value < 50)
        }
    }
}