package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.word.Word

sealed class SearchState(val query: String) {

    object Idle: SearchState("")

    class Loading(query: String): SearchState(query)

    class Error(query: String): SearchState(query)

    class Result(query: String, val words: List<Word>): SearchState(query)
}