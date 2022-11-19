@file:OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)

package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.LanguageViewModel
import com.faltenreich.rhyme.shared.architecture.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds

class SearchViewModel(
    private val searchUseCase: SearchUseCase,
    languageViewModel: LanguageViewModel,
): ViewModel() {

    val state = MutableStateFlow<SearchState>(SearchState.Idle)

    init {
        state
            .filterIsInstance<SearchState.Loading>()
            .debounce(1.seconds)
            .distinctUntilChanged()
            .combine(languageViewModel.state) { state, language ->
                state.query to language.currentLanguage
            }
            .flatMapLatest { (query, language) -> searchUseCase(query, language) }
            .onEach { words -> state.value = SearchState.Result(SearchState.Idle.query, words) }
            .launchIn(viewModelScope)
    }

    fun onQueryChanged(query: String) {
        state.value = if (query.isBlank()) SearchState.Idle else SearchState.Loading(query)
    }
}