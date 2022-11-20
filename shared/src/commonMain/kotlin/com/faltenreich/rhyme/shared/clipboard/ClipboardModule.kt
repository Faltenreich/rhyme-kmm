package com.faltenreich.rhyme.shared.clipboard

import org.koin.dsl.bind
import org.koin.dsl.module

fun clipboardModule() = module {
    single { SystemClipboard() } bind Clipboard::class
}