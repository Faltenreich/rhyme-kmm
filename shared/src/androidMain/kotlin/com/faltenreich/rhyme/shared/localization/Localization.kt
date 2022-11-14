package com.faltenreich.rhyme.shared.localization

import androidx.compose.ui.text.intl.Locale
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual class Localization actual constructor(private val context: android.content.Context) {

    actual fun getLanguageCode(): String {
        return Locale.current.language
    }

    actual fun getString(resource: StringResource): String {
        return StringDesc.Resource(resource).toString(context)
    }
}