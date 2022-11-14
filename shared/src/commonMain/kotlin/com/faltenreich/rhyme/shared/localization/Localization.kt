package com.faltenreich.rhyme.shared.localization

import dev.icerock.moko.resources.StringResource

expect class Localization constructor(context: Context) {

    fun getLanguageCode(): String

    fun getString(resource: StringResource): String
}