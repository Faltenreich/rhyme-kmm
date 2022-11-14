package com.faltenreich.rhyme.shared.localization

import dev.icerock.moko.resources.StringResource

expect fun getLanguageCode(): String

expect fun getString(resource: StringResource): String