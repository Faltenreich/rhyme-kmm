package com.faltenreich.rhyme.search

import com.faltenreich.rhyme.language.Language
import com.faltenreich.rhyme.word.Word
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class SearchUseCase(
    private val repository: SearchRepository,
    private val dispatcher: CoroutineDispatcher,
) {

    operator fun invoke(query: String, language: Language): Flow<List<Word>> {
        return repository.search(query, language).flowOn(dispatcher)
    }
}