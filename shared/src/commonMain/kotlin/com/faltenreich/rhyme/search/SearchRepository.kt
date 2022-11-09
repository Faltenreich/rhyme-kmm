package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.word.Word

class SearchRepository(private val api: SearchApi) {

    suspend fun search(query: String?, language: Language): List<Word> {
        val json = api.search(query, language)
        TODO()
    }
}