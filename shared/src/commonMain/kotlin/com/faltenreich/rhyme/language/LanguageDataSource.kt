package com.faltenreich.rhyme.language

interface LanguageDataSource {

    fun getCurrentLanguage(): Language
    fun setCurrentLanguage(language: Language)
}