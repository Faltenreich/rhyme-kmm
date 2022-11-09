package com.faltenreich.rhyme.search.rhymebrain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RhymeBrainWord(
    @SerialName("word")
    val word: String?,
    @SerialName("syllables")
    val syllables: String?,
    @SerialName("freq")
    val frequency: Int?,
    @SerialName("score")
    val score: Int?,
    @SerialName("flags")
    val flags: String?,
)