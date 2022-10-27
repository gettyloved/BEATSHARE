package com.beatshare.beatshare.utils

import androidx.compose.ui.graphics.Color
import com.beatshare.beatshare.ui.theme.*
import kotlin.random.Random


internal fun <T> getRandomElement(elements:List<T>):T{
    val randomIndex = Random.nextInt(elements.size)
    return elements[randomIndex]
}

fun generateRandomColors():Color{
    val colors = listOf(pink,orange, yellow,
    blue, babyBlue, grey, purple, teal, heavyTeal,
    babyYellow, maroon)
    return getRandomElement(colors)
}