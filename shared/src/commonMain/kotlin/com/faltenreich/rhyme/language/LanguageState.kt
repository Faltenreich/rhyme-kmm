package com.faltenreich.rhyme.language

sealed class LanguageState(val languages: List<Language> = Language.values().toList()) {

    object Loading: LanguageState()

    class Loaded(val currentLanguage: Language): LanguageState()
}