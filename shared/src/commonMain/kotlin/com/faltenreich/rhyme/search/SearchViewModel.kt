@file:OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)

package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.shared.architecture.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds

class SearchViewModel(
    private val searchUseCase: SearchUseCase,
): ViewModel() {

    val state = MutableStateFlow<SearchState>(SearchState.Idle)

    init {
        state
            .filterIsInstance<SearchState.Loading>()
            .debounce(1.seconds)
            .distinctUntilChanged()
            .flatMapLatest { state -> searchUseCase(state.query) }
            .onEach { words -> state.value = SearchState.Result(state.value.query, words) }
            .launchIn(viewModelScope)
    }

    fun onQueryChanged(query: String) {
        state.value = if (query.isBlank()) SearchState.Idle else SearchState.Loading(query)
    }
}