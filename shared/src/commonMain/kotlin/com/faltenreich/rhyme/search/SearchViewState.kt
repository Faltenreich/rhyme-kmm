package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.word.Word

data class SearchViewState(
    val query: String = "",
    val results: List<Word> = emptyList(),
)