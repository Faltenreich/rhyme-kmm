@file:OptIn(ExperimentalCoroutinesApi::class)

package com.faltenreich.rhyme.shared.architecture

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import org.koin.dsl.bind
import org.koin.dsl.module

fun coroutineModule() = module {
    single { StandardTestDispatcher() } bind CoroutineDispatcher::class
}