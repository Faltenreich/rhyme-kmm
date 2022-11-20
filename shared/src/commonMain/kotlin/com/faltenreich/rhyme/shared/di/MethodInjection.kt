package com.faltenreich.rhyme.shared.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

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
    inline fun <reified T: Any> inject(
        qualifier: Qualifier? = null,
        noinline parameters: ParametersDefinition? = null,
    ): T = get(qualifier, parameters)
}

inline fun <reified T: Any> inject(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null,
): T = MethodInjection.inject(qualifier, parameters)