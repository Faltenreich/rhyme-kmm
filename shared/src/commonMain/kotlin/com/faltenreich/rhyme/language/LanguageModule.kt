package com.faltenreich.rhyme.language

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun languageModule() = module {
    singleOf(::LanguageViewModel)
}