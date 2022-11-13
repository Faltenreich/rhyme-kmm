package com.faltenreich.rhyme.language

import kotlinx.coroutines.flow.MutableStateFlow

class LanguageViewModel {

    // TODO: Read language from os or shared prefs / user defaults
    val state = MutableStateFlow(LanguageViewState(Language.ENGLISH))

    fun setCurrentLanguage(language: Language) {
        state.value = state.value.copy(currentLanguage = language)
    }
}