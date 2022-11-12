package com.faltenreich.rhyme

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual fun getString(resource: StringResource): String {
    return StringDesc.Resource(resource).toString(ContextLocator.context)
}