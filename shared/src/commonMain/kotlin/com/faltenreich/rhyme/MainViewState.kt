package com.faltenreich.rhyme

import com.faltenreich.rhyme.word.Word

data class MainViewState(
    val words: List<Word> = emptyList(),
    val loading: Boolean = false,
)