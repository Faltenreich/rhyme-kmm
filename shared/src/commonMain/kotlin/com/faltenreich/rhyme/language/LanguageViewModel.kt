package com.faltenreich.rhyme.language

import com.faltenreich.rhyme.shared.architecture.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map

class LanguageViewModel(private val repository: LanguageRepository): ViewModel() {

    private val state = MutableStateFlow(LanguageState(currentLanguage = Language.default))
    val uiState = state.asStateFlow()

    init {
        repository.currentLanguage
            .map { language -> state.value = state.value.copy(currentLanguage = language) }
            .launchIn(viewModelScope)
    }

    fun setCurrentLanguage(language: Language) {
        repository.setLanguage(language)
    }
}