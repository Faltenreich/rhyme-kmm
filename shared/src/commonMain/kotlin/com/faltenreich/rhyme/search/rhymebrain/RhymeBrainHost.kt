package com.faltenreich.rhyme.search.rhymebrain

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.search.SearchHost

class RhymeBrainHost: SearchHost {

    override fun getUrl(query: String?, language: Language): String {
        return "https://rhymebrain.com/talk?function=getRhymes&lang=${language.code}&word=$query"
    }
}