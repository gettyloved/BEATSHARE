package com.beatshare.beatshare

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ArtistsSignUpViewModel: ViewModel() {
    //    MUTABLESTATEfLOW
    private val _artistSignupData = MutableStateFlow<ArtistSignupData>(ArtistSignupData.EMPTY)
    private val currentSignUpData:ArtistSignupData
        get() = _artistSignupData.value
    private val _artistsSignupContData = MutableStateFlow(ArtistSignupContData.EMPTY)

    private val _artistsSignUpDataValid = MutableStateFlow(ArtistsSignUpDataValid.EMPTY)
    val artistsSignUpDataValid:StateFlow<ArtistsSignUpDataValid>
        get() = _artistsSignUpDataValid

    //    STATEFLOW
    val artistSignupData : StateFlow<ArtistSignupData> get() =_artistSignupData
    val artistSignupContData: StateFlow<ArtistSignupContData> get() = _artistsSignupContData

    //   FUNCTIONS
    fun setArtistSignUpDetails (artistSignupData: ArtistSignupData){
        _artistSignupData.update {
            it.copy(firstName = artistSignupData.firstName, lastName = artistSignupData.lastName,
                userName = artistSignupData.userName, email = artistSignupData.email
            )
        }
    }

    fun setArtistContSignupDetails(artistSignupContData: ArtistSignupContData){
        _artistsSignupContData.update{
            it.copy(country = artistSignupContData.country, city = artistSignupContData.city,
                zip = artistSignupContData.zip)
        }
    }

    fun validateUserCredentials():Boolean{
        val passwordRegex = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$".toRegex()
        val isEmailValid=currentSignUpData.email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(currentSignUpData.email).matches()
        val isUsernameValid = currentSignUpData.userName.isNotEmpty() && currentSignUpData.userName.length>8
        val isFirstNameValid =currentSignUpData.firstName.isNotEmpty() && currentSignUpData.firstName.length>8
        val isLastNameValid =currentSignUpData.lastName.isNotEmpty() && currentSignUpData.lastName.length>8
        val isPasswordValid = currentSignUpData.password.isNotEmpty() && currentSignUpData.password.matches(passwordRegex)

        _artistsSignUpDataValid.update {
            it.copy(isFirstNameValid = isFirstNameValid,isLastNameValid = isLastNameValid,
                isEmailValid = isEmailValid, isUserNameValid = isUsernameValid, isPasswordValid = isPasswordValid)
        }
        return isEmailValid && isFirstNameValid && isUsernameValid && isLastNameValid && isPasswordValid
    }
}