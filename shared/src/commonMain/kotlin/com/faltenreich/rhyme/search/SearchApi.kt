package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.word.Word

interface SearchApi {

    suspend fun search(query: String?, language: Language): List<Word>
}