package com.beatshare.beatshare

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class TrackItems(
    val color:Int,
    val title:String,
    val subTitle:String
)
