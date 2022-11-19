package com.faltenreich.rhyme

import com.faltenreich.rhyme.language.languageModule
import com.faltenreich.rhyme.search.searchModule
import com.faltenreich.rhyme.shared.architecture.coroutineModule
import com.faltenreich.rhyme.shared.localization.localizationModule

fun mainModule() = listOf(
    coroutineModule(),
    localizationModule(),
    languageModule(),
    searchModule(),
)