package com.faltenreich.rhyme.search

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
): KoinComponent {

    val state = MutableStateFlow<SearchViewState>(Idle)

    init {
        GlobalScope.launch {
            state
                .debounce(INPUT_SEARCH_DELAY)
                .filter { it is Loading  }
                .collect { loading ->
                    val query = loading.query
                    val result = api.search(query, Language.GERMAN).sortedByDescending(Word::score)
                    println("Found ${result.size} words for query: $query")
                    state.value = Result(query, result)
                }
        }
    }

    fun onQueryChanged(query: String) {
        state.value = if (query.isBlank()) Idle else Loading(query)
    }

    companion object {

        private val INPUT_SEARCH_DELAY = 1.seconds
    }
}