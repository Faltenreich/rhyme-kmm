package com.faltenreich.rhyme.language

import kotlinx.coroutines.flow.MutableStateFlow

class LanguageRepository(private val dataSource: LanguageDataSource) {

    var currentLanguage = MutableStateFlow(dataSource.getCurrentLanguage())

    suspend fun setLanguage(language: Language) {
        dataSource.setCurrentLanguage(language)
        currentLanguage.value = language
    }
}