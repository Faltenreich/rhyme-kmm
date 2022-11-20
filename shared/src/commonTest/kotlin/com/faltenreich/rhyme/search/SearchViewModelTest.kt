package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.shared.di.inject
import com.faltenreich.rhyme.testModule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import kotlin.test.*

class SearchViewModelTest: KoinTest {

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
    fun `opens in idle state`() {
        val viewModel = inject<SearchViewModel>()
        assertEquals(SearchState.Idle, viewModel.uiState.value)
    }

    @Test
    fun `reaches idle state on blank query`() {
        val viewModel = inject<SearchViewModel>()
        viewModel.onQueryChanged("")
        assertEquals(SearchState.Idle, viewModel.uiState.value)
    }

    @Test
    fun `reaches loading state on non-blank query`() {
        val viewModel = inject<SearchViewModel>()
        viewModel.onQueryChanged("Query")
        assertTrue(viewModel.uiState.value is SearchState.Loading)
    }
}