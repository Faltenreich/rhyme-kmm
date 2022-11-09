package com.faltenreich.rhyme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.search.SearchRepository
import com.faltenreich.rhyme.search.rhymebrain.RhymeBrainApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchRepository: SearchRepository = SearchRepository(RhymeBrainApi()),
) {

    var uiState by mutableStateOf(MainViewState())
        private set

    init {
        fetchWords()
    }

    private fun fetchWords() {
        GlobalScope.launch {
            val words = searchRepository.search("essen", Language.GERMAN)
            uiState = uiState.copy(words = words)
        }
    }
}