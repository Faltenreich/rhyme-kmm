package com.faltenreich.rhyme.shared.architecture

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

fun coroutineModule() = module {
    single { Dispatchers.Default }
}