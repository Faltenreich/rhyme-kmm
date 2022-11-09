package com.faltenreich.rhyme.search.rhymebrain

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.search.SearchApi
import com.faltenreich.rhyme.word.Word

class RhymeBrainApi: SearchApi {

    override suspend fun search(query: String?, language: Language): List<Word> {
        TODO("Not yet implemented")
    }
}