package com.faltenreich.rhyme.shared.localization

import androidx.compose.ui.text.intl.Locale
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual class Localization actual constructor(private val context: Context) {

    actual fun getLanguageCode(): String {
        return Locale.current.language
    }

    actual fun getString(resource: StringResource): String {
        return StringDesc.Resource(resource).toString(context)
    }
}