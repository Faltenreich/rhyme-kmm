package com.faltenreich.rhyme.shared.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/**
 * Convenience wrapper for dependency injection where constructor injection is not possible,
 * e.g. in Composable functions as Compose Multiplatform is not yet supported by Koin
 */
object MethodInjection: KoinComponent {

    /**
     * Resolve dependency that has been injected
     *
     * @return Resolved dependency
     */
    inline fun <reified T: Any> inject(): T = get()
}

inline fun <reified T: Any> inject(): T = MethodInjection.inject()