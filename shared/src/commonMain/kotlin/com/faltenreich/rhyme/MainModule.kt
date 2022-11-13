package com.faltenreich.rhyme

import com.faltenreich.rhyme.language.languageModule
import com.faltenreich.rhyme.search.searchModule

fun mainModule() = listOf(
    languageModule(),
    searchModule(),
)