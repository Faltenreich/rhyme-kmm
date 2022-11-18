package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.LanguageViewModel
import com.faltenreich.rhyme.search.api.SearchApi
import com.faltenreich.rhyme.word.Word
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import kotlin.time.Duration.Companion.seconds

@OptIn(FlowPreview::class)
class SearchViewModel(
    private val api: SearchApi,
    private val languageViewModel: LanguageViewModel,
): KoinComponent {

    val state = MutableStateFlow<SearchState>(SearchState.Idle)

    init {
        GlobalScope.launch {
            state
                .debounce(INPUT_SEARCH_DELAY)
                .filter { it is SearchState.Loading  }
                .collect { loading ->
                    val query = loading.query
                    // TODO: Collect accordingly, so changing the language immediately affects the search
                    val language = languageViewModel.state.value.currentLanguage
                    val result = api.search(query, language).sortedByDescending(Word::score)
                    println("Found ${result.size} words for query: $query")
                    state.value = SearchState.Result(query, result)
                }
        }
    }

    fun onQueryChanged(query: String) {
        state.value = if (query.isBlank()) SearchState.Idle else SearchState.Loading(query)
    }

    companion object {

        private val INPUT_SEARCH_DELAY = 1.seconds
    }
}