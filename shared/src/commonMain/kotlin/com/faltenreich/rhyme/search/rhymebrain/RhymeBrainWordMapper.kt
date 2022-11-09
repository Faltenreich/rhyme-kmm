package com.faltenreich.rhyme.search.rhymebrain

import com.faltenreich.rhyme.search.WordMapper
import com.faltenreich.rhyme.word.Word

class RhymeBrainWordMapper: WordMapper<RhymeBrainWord> {

    override fun map(input: RhymeBrainWord): Word {
        val name = input.word ?: throw IllegalArgumentException("Name must not be null")
        return Word(
            name = name,
            syllables = input.syllables?.toIntOrNull() ?: 1,
            frequency = input.frequency ?: 0,
            score = input.score ?: 0,
            isOffensive = input.flags?.contains("a") ?: false,
        )
    }
}