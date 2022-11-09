package com.faltenreich.rhyme.search.rhymebrain

import com.faltenreich.rhyme.search.SearchParser
import com.faltenreich.rhyme.search.WordMapper
import com.faltenreich.rhyme.serialization.JsonSerialization
import com.faltenreich.rhyme.serialization.decode
import com.faltenreich.rhyme.word.Word

class RhymeBrainParser(
    private val serialization: JsonSerialization,
    private val mapper: WordMapper<RhymeBrainWord>,
): SearchParser {

    override fun parseWord(json: String): Word {
        val dto = serialization.decode<RhymeBrainWord>(json)
        return mapper.map(dto)
    }
}