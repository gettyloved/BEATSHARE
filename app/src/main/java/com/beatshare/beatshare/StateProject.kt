package com.beatshare.beatshare

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Immutable
data class ArtistSignupData(
    val firstName:String,
    val lastName:String,
    val userName:String,
    val email:String,
    val password:String
){
    companion object{
        val EMPTY = ArtistSignupData("","","","","")
    }
}

@Immutable
data class ArtistsSignUpDataValid(
    val isFirstNameValid:Boolean, val isLastNameValid:Boolean,
    val isUserNameValid:Boolean,val isEmailValid:Boolean, val isPasswordValid:Boolean){
    companion object{
        val EMPTY = ArtistsSignUpDataValid(isFirstNameValid = true, isLastNameValid = true,isUserNameValid = true,
            isEmailValid = true, isPasswordValid = true)
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