@file:OptIn(ExperimentalCoroutinesApi::class)

package com.faltenreich.rhyme.search

import app.cash.turbine.test
import com.faltenreich.rhyme.shared.di.inject
import com.faltenreich.rhyme.testModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import kotlin.test.*

class SearchUseCaseTest {

    @BeforeTest
    fun setup() {
        startKoin {
            modules(testModule())
        }
    }

    @AfterTest
    fun clean() {
        stopKoin()
    }

    @Test
    fun `searches words`() = runTest {
        val useCase = inject<SearchUseCase>()
        val query = "Query"
        useCase(query).test {
            val a = awaitItem()
            assertTrue(awaitItem().isEmpty())
        }
    }

    @Test
    fun `flow is running`() = runTest {
        flowOf("one", "two").test {
            assertEquals("one", awaitItem())
        }
    }
}