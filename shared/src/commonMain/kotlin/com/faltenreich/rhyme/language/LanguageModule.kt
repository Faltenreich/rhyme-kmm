package com.faltenreich.rhyme.language

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun languageModule() = module {
    singleOf(::LanguageInMemoryDataSource) bind LanguageDataSource::class
    singleOf(::LanguageRepository)
    singleOf(::LanguageViewModel)
}