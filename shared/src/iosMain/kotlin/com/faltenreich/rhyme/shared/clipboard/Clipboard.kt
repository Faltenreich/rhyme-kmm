package com.faltenreich.rhyme.shared.clipboard

actual class Clipboard {

    actual fun copyToClipboard(string: String) {
        UIPasteboard.general.string = string
    }
}