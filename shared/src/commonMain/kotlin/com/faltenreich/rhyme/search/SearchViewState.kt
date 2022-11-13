package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.word.Word

sealed class SearchViewState(val query: String)

object Idle: SearchViewState("")

class Loading(query: String): SearchViewState(query)

class Error(query: String): SearchViewState(query)

class Result(query: String, val words: List<Word>): SearchViewState(query)