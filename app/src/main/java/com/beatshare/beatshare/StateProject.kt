package com.beatshare.beatshare

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Immutable
data class ArtistSignupData(
   val firstName:String,
   val lastName:String,
   val userName:String,
   val email:String
){
    companion object{
        val EMPTY = ArtistSignupData("","","","")
    }
}

@Immutable
data class ArtistSignupContData(
    val country:String,
    val city:String,
    val zip:String
){
    companion object{
        val EMPTY = ArtistSignupContData("","","")
    }
}
