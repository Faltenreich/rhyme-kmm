package com.faltenreich.rhyme.shared.localization

import dev.icerock.moko.resources.StringResource

expect class SystemLocalization constructor(context: Context): Localization {

    override fun getLanguageCode(): String

    override fun getString(resource: StringResource): String
}