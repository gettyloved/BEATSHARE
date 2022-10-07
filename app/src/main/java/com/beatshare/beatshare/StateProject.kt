package com.beatshare.beatshare

import androidx.compose.runtime.Stable

@Stable
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

@Stable
data class ArtistSignupContData(
    val country:String,
    val city:String,
    val zip:String
){
    companion object{
        val EMPTY = ArtistSignupContData("","","")
    }
}
