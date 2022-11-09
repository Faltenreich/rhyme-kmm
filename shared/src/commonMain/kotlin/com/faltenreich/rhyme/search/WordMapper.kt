package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.word.Word

interface WordMapper<T: Any> {

    fun map(input: T): Word
}