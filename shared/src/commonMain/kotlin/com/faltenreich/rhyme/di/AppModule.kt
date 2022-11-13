package com.faltenreich.rhyme.di

import com.faltenreich.rhyme.search.searchModule

fun appModule() = listOf(
    searchModule(),
)