package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.search.api.SearchApi
import com.faltenreich.rhyme.word.Word
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import kotlin.time.Duration.Companion.seconds

class SearchViewModel(
    private val api: SearchApi,
): KoinComponent {

    private val query = MutableStateFlow("")
    private val words = MutableStateFlow(emptyList<Word>())
    val uiState = query.combine(words, ::SearchViewState)

    init {
        GlobalScope.launch {
            query.debounce(INPUT_SEARCH_DELAY)
                .collect { query ->
                    val result = api.search(query, Language.GERMAN)
                    println("Found ${result.size} words for query: $query")
                    words.value = result.sortedByDescending(Word::score)
                }
        }
    }

    fun search(query: String) {
        this.query.value = query
    }

    fun reset() {
        this.query.value = ""
    }

    companion object {

        private val INPUT_SEARCH_DELAY = 1.seconds
    }
}