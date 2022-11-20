package com.faltenreich.rhyme.shared.clipboard

expect class SystemClipboard constructor(): Clipboard {

    override fun copyToClipboard(string: String)
}