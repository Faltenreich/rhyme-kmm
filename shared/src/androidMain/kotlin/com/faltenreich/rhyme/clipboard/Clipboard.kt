package com.faltenreich.rhyme.clipboard

import android.content.ClipData
import android.content.ClipboardManager
import com.faltenreich.rhyme.Context
import com.faltenreich.rhyme.ContextLocator

actual class Clipboard {

    actual fun copyToClipboard(string: String) {
        val clipboard = ContextLocator.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("", string)
        clipboard.setPrimaryClip(clip)
    }
}