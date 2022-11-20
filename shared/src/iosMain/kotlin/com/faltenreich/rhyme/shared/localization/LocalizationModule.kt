package com.faltenreich.rhyme.shared.localization

import org.koin.dsl.bind
import org.koin.dsl.module

actual fun localizationModule() = module {
    single { SystemLocalization(Context()) } bind Localization::class
}