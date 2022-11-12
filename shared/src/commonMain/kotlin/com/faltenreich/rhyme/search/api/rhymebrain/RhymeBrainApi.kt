package com.faltenreich.rhyme.search.api.rhymebrain

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.networking.KtorClient
import com.faltenreich.rhyme.networking.NetworkingClient
import com.faltenreich.rhyme.search.api.SearchApi
import com.faltenreich.rhyme.search.api.WordMapper
import com.faltenreich.rhyme.serialization.JsonSerialization
import com.faltenreich.rhyme.word.Word
import io.ktor.client.engine.cio.*

class RhymeBrainApi(
    private val networkingClient: NetworkingClient = KtorClient(CIO.create()),
    private val serialization: JsonSerialization = JsonSerialization(),
    private val mapper: WordMapper<RhymeBrainWord> = RhymeBrainWordMapper(),
): SearchApi {

    override suspend fun search(query: String?, language: Language): List<Word> {
        // FIXME: Results seem off and ignoring language
        val url = "$HOST/talk?function=getRhymes&lang=${language.code}&word=$query"
        val json = networkingClient.request(url)
        val dtoList = serialization.decode<List<RhymeBrainWord>>(json)
        return dtoList.map(mapper::map)
    }

    companion object {

        private const val HOST = "https://rhymebrain.com"
    }
}