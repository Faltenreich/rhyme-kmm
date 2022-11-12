package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.word.Word
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

// Workaround: Singleton fixes redundant initialization
// Convert to non-singleton via dependency injection
object SearchViewModel {

    private val query = MutableStateFlow("")
    private val words = MutableStateFlow(emptyList<Word>())
    val uiState = query.combine(words, ::SearchViewState)

    init {
        GlobalScope.launch {
            // As soon the textSearch flow changes,
            // if the user stops typing for 1000ms, the item will be emitted
            query.debounce(1000).collect { query ->
                // Call the search function here using the query param
                println("Updated query: $query")
            }
        }
    }

    fun search(query: String) {
        this.query.value = query
    }
}