package com.faltenreich.rhyme.shared.localization

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual class Localization actual constructor(context: Context) {

    actual fun getLanguageCode(): String {
        return NSLocale.currentLocale.languageCode
    }

    actual fun getString(resource: StringResource): String {
        return StringDesc.Resource(resource).localized()
    }
}