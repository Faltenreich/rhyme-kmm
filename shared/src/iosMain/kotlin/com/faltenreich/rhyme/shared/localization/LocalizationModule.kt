package com.faltenreich.rhyme.shared.localization

import org.koin.dsl.module

actual fun localizationModule() = module {
    single { Localization(Context()) }
}