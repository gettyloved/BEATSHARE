package com.beatshare.beatshare

sealed class Screen(val route:String){
    object LogIn:Screen(route = "login")
    object BeatsProducer:Screen(route = "beatsProducer")
    object ArtistVProducer:Screen(route = "artistVProducer")
    object ArtistHome:Screen(route = "artistHome")
    object ProducersHome:Screen(route = "producersHome")
    object ArtistSignUp:Screen(route = "artistSignUp")
    object ProducerSignUp:Screen(route = "producerSignUp")
    object ArtistSignUpCont:Screen(route = "artistSignUpCont")
    object ProducerSignUpCont:Screen(route = "producerSignUpCont")
    object UploadBeats:Screen(route = "uploadBeats")
    object DigitCode:Screen(route = "digitCode")
    object ForgotPassword:Screen(route = "forgotPassword")
    object GuestAccount:Screen(route = "guestAccount")
    object PasswordReset:Screen(route = "passwordReset")
    object Library:Screen(route = "library")
    object ProducersProfile:Screen(route = "producersProfile")
    object Search:Screen(route = "search")
    object Settings:Screen(route = "settings")
}
