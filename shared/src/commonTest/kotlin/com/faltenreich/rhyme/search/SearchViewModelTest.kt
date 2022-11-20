package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.shared.di.inject
import com.faltenreich.rhyme.testModule
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SearchViewModelTest: KoinTest {

    @Test
    fun `opens in idle state`() {
        startKoin {
            modules(testModule())
        }
        val viewModel = inject<SearchViewModel>()
        assertEquals(SearchState.Idle, viewModel.uiState.value)
    }
}