package com.faltenreich.rhyme.language

import com.faltenreich.rhyme.shared.localization.getLanguageCode
import kotlinx.coroutines.flow.MutableStateFlow

class LanguageViewModel {

    val state = MutableStateFlow(LanguageViewState(
        languages = Language.values().toList(),
        currentLanguage = getSystemLanguage(),
    ))

    private fun getSystemLanguage(): Language {
        return Language.fromLanguageCode(getLanguageCode()) ?: Language.ENGLISH
    }

    fun setCurrentLanguage(language: Language) {
        state.value = state.value.copy(currentLanguage = language)
    }
}