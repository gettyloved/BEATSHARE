package com.beatshare.beatshare

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TheViewModel: ViewModel() {
//    state
    var mFirstNameText by mutableStateOf("")
    var mLastNameText by mutableStateOf("")
    var mUserNameText by  mutableStateOf("")
    var mEmailText by mutableStateOf("")
    var mPassword by mutableStateOf("")
    var mConfirmPassword by mutableStateOf("")
    var isPasswordVisible by mutableStateOf(false)
    var isConfirmPasswordVisible by mutableStateOf(false)

    var pFirstNameText by mutableStateOf("")
    var pLastNameText by mutableStateOf("")
    var pUserNameText by  mutableStateOf("")
    var pEmailText by mutableStateOf("")
    var pPassword by mutableStateOf("")
    var pConfirmPassword by mutableStateOf("")
    var ispPasswordVisible by mutableStateOf(false)
    var ispConfirmPasswordVisible by mutableStateOf(false)

    var mCountry by mutableStateOf("")
    var mCity by mutableStateOf("")
    var mZip by mutableStateOf("")

//    events
    fun onmFirstNameTextChanged(newString: String){mFirstNameText = newString}
    fun onmLastNameTextChanged(newString: String){mLastNameText = newString}
    fun onmUserNameTextChanged(newString: String){mUserNameText = newString}
    fun onmEmailTextChanged(newString: String){mEmailText = newString}
    fun onmPasswordChanged(newString: String){mPassword = newString}
    fun onmConfirmPasswordChanged(newString: String){mConfirmPassword = newString}

    fun onpFirstNameTextChanged(newString: String){pFirstNameText = newString}
    fun onpLastNameTextChanged(newString: String){pLastNameText = newString}
    fun onpUserNameTextChanged(newString: String){pUserNameText = newString}
    fun onpEmailTextChanged(newString: String){pEmailText = newString}
    fun onpPasswordChanged(newString: String){pPassword = newString}
    fun onpConfirmPasswordChanged(newString: String){pConfirmPassword = newString}

    fun onmCountryTextChanged(newString: String){mCountry = newString}
    fun onmCityTextChanged(newString: String){mCity = newString}
    fun onmZipTextChanged(newString: String){mZip = newString}
}