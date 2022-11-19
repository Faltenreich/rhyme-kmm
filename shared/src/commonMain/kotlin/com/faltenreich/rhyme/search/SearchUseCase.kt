@file:OptIn(ExperimentalCoroutinesApi::class)

package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.LanguageRepository
import com.faltenreich.rhyme.word.Word
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn

class SearchUseCase(
    private val searchRepository: SearchRepository,
    private val languageRepository: LanguageRepository,
    private val dispatcher: CoroutineDispatcher,
) {

    operator fun invoke(query: String): Flow<List<Word>> {
        return languageRepository.currentLanguage
            .flatMapLatest { language -> searchRepository.search(query, language) }
            .flowOn(dispatcher)
    }
}