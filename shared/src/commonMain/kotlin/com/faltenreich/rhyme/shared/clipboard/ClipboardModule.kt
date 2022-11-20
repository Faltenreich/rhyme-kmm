package com.faltenreich.rhyme.shared.clipboard

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun clipboardModule() = module {
    singleOf(::Clipboard)
}