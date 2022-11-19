@file:OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)

package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.LanguageViewModel
import com.faltenreich.rhyme.search.SearchState.Idle.query
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import kotlin.time.Duration.Companion.seconds

class SearchViewModel(
    private val repository: SearchRepository,
    private val languageViewModel: LanguageViewModel,
): KoinComponent {

    val state = MutableStateFlow<SearchState>(SearchState.Idle)

    init {
        GlobalScope.launch {
            state
                .filterIsInstance<SearchState.Loading>()
                .debounce(1.seconds)
                .distinctUntilChanged()
                .combine(languageViewModel.state) { state, language ->
                    state.query to language.currentLanguage
                }
                .flatMapLatest { (query, language) -> repository.search(query, language) }
                .collect { words -> state.value = SearchState.Result(query, words) }
        }
    }

    fun onQueryChanged(query: String) {
        state.value = if (query.isBlank()) SearchState.Idle else SearchState.Loading(query)
    }
}