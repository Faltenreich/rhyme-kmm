package com.faltenreich.rhyme.language

data class LanguageViewState(
    val languages: List<Language>,
    val currentLanguage: Language,
)