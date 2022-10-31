package com.beatshare.beatshare

import androidx.compose.runtime.Immutable

@Immutable
data class ArtistsSignUpContDataValid(
    val isCountryValid:Boolean,
    val isCityValid:Boolean,
    val isZipValid:Boolean
){
    companion object{
        val EMPTY = ArtistsSignUpContDataValid(
            isCountryValid = true,
            isCityValid = true,
            isZipValid = true
        )
    }
}
