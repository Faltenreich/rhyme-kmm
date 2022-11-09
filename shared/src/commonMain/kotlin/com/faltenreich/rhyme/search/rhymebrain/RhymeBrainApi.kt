package com.faltenreich.rhyme.search.rhymebrain

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.networking.KtorClient
import com.faltenreich.rhyme.networking.NetworkingClient
import com.faltenreich.rhyme.search.SearchApi
import com.faltenreich.rhyme.search.WordMapper
import com.faltenreich.rhyme.serialization.JsonSerialization
import com.faltenreich.rhyme.serialization.KotlinxSerialization
import com.faltenreich.rhyme.serialization.decode
import com.faltenreich.rhyme.word.Word
import io.ktor.client.engine.cio.*

class RhymeBrainApi(
    private val networkingClient: NetworkingClient = KtorClient(CIO.create()),
    private val serialization: JsonSerialization = KotlinxSerialization(),
    private val mapper: WordMapper<RhymeBrainWord> = RhymeBrainWordMapper(),
): SearchApi {

    override suspend fun search(query: String?, language: Language): List<Word> {
        val url = "$HOST/talk?function=getRhymes&lang=${language.code}&word=$query"
        val json = networkingClient.request(url)
        // FIXME: JsonDecodingException
        val dtoList = serialization.decode<List<RhymeBrainWord>>(json)
        val words = dtoList.map(mapper::map)
        return words
    }

    companion object {

        private const val HOST = "https://rhymebrain.com"
    }
}