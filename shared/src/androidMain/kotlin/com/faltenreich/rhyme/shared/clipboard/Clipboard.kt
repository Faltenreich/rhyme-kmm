package com.faltenreich.rhyme.shared.clipboard

import android.content.ClipData
import android.content.ClipboardManager
import com.faltenreich.rhyme.shared.localization.Context
import com.faltenreich.rhyme.shared.localization.ContextLocator

actual class Clipboard {

    actual fun copyToClipboard(string: String) {
        val context = ContextLocator.context
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("", string)
        clipboard.setPrimaryClip(clip)
    }
}