package com.beatshare.beatshare

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TheViewModel: ViewModel() {
//    MUTABLESTATEfLOW
   private val _artistSignupData = MutableStateFlow<ArtistSignupData>(ArtistSignupData.EMPTY)
   private val _artistsSignupContData = MutableStateFlow<ArtistSignupContData>(ArtistSignupContData.EMPTY)

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
}