package com.faltenreich.rhyme.language

import com.faltenreich.rhyme.shared.localization.Localization
import kotlinx.coroutines.flow.MutableStateFlow

class LanguageViewModel(private val localization: Localization) {

    val state = MutableStateFlow(LanguageViewState(
        languages = Language.values().toList(),
        currentLanguage = getSystemLanguage(),
    ))

    private fun getSystemLanguage(): Language {
        return Language.fromLanguageCode(localization.getLanguageCode()) ?: Language.ENGLISH
    }

    fun setCurrentLanguage(language: Language) {
        state.value = state.value.copy(currentLanguage = language)
    }
}