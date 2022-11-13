package com.faltenreich.rhyme.word

class WordViewModel(private val word: Word) {

    fun onClick() {
        println("Clicked word: $word")
    }
}