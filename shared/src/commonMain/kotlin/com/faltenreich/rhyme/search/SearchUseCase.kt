@file:OptIn(ExperimentalCoroutinesApi::class)

package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.LanguageViewModel
import com.faltenreich.rhyme.word.Word
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn

class SearchUseCase(
    private val repository: SearchRepository,
    private val languageViewModel: LanguageViewModel,
    private val dispatcher: CoroutineDispatcher,
) {

    operator fun invoke(query: String): Flow<List<Word>> {
        return languageViewModel.state
            .flatMapLatest { language -> repository.search(query, language.currentLanguage) }
            .flowOn(dispatcher)
    }
}