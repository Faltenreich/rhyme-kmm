package com.faltenreich.rhyme.language

import com.faltenreich.rhyme.shared.architecture.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class LanguageViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val repository: LanguageRepository,
): ViewModel() {

    private val state = MutableStateFlow<LanguageState>(LanguageState.Loading)
    val uiState = state.asStateFlow()

    init {
        repository.currentLanguage
            .map { language -> state.value = LanguageState.Loaded(language) }
            .launchIn(viewModelScope)
    }

    fun setCurrentLanguage(language: Language) {
        viewModelScope.launch(dispatcher) {
            repository.setLanguage(language)
        }
    }
}