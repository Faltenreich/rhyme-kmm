package com.faltenreich.rhyme.word

import com.faltenreich.rhyme.clipboard.Clipboard

class WordViewModel(
    private val word: Word,
    private val clipboard: Clipboard = Clipboard(),
) {

    fun onClick() {
        clipboard.copyToClipboard(word.name)
    }
}