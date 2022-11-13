package com.faltenreich.rhyme.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object ViewModelFactory: KoinComponent {

    inline fun <reified T: Any> create() = get<T>()
}