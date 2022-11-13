package com.faltenreich.rhyme.shared.di

import com.faltenreich.rhyme.search.searchModule

fun appModule() = listOf(
    searchModule(),
)