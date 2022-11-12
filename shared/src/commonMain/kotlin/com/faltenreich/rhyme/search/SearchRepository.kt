package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.search.api.SearchApi
import com.faltenreich.rhyme.word.Word

class SearchRepository(private val api: SearchApi) {

    suspend fun search(query: String?, language: Language): List<Word> {
        return api.search(query, language)
    }
}