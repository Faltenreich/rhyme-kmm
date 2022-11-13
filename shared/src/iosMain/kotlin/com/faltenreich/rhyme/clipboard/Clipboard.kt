package com.faltenreich.rhyme.clipboard

import platform.UIKit.UIPasteboard

actual class Clipboard {

    actual fun copyToClipboard(string: String) {
        UIPasteboard.general.string = string
    }
}