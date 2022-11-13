package com.faltenreich.rhyme.search.api

import com.faltenreich.rhyme.search.Language

interface SearchHost {

    fun getUrl(query: String?, language: Language): String
}