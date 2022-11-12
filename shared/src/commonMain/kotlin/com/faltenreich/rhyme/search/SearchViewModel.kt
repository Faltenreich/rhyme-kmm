package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.search.api.rhymebrain.RhymeBrainApi
import com.faltenreich.rhyme.word.Word
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

// Workaround: Singleton fixes redundant initialization
// TODO: Convert to non-singleton via dependency injection
object SearchViewModel {

    private val INPUT_SEARCH_DELAY = 1.seconds

    private val repository = SearchRepository(RhymeBrainApi())

    private val query = MutableStateFlow("")
    private val words = MutableStateFlow(emptyList<Word>())
    val uiState = query.combine(words, ::SearchViewState)

    init {
        GlobalScope.launch {
            query.debounce(INPUT_SEARCH_DELAY)
                .collect { query ->
                    val result = repository.search(query, Language.GERMAN)
                    println("Found ${result.size} words for query: $query")
                    words.value = result
                }
        }
    }

    fun search(query: String) {
        this.query.value = query
    }
}