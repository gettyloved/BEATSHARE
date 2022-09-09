package com.beatshare.beatshare

sealed class Screen(val route:String){
    object LogIn:Screen(route = "login")
    object Beats:Screen(route = "beats")
    object ArtistVProducer:Screen(route = "artistVProducer")
    object ArtistHome:Screen(route = "artistHome")
    object ProducersHome:Screen(route = "producersHome")
    object ArtistSignUp:Screen(route = "artistSignUp")
    object ProducerSignUp:Screen(route = "producerSignUp")
    object ArtistSignUpCont:Screen(route = "artistSignUpCont")
    object ProducerSignUpCont:Screen(route = "producerSignUpCont")
}
