package com.faltenreich.rhyme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform