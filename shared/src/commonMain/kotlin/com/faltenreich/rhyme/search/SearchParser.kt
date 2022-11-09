package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.word.Word

interface SearchParser {

    fun parseWord(json: String): Word?
}