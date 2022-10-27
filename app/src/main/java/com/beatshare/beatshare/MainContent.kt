package com.beatshare.beatshare

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.beatshare.beatshare.home.ArtistsHome
import com.beatshare.beatshare.home.BeatsProducer
import com.beatshare.beatshare.home.ProducersHome
import com.beatshare.beatshare.home.UploadBeats
import com.beatshare.beatshare.login.*
import com.beatshare.beatshare.profile.Library
import com.beatshare.beatshare.profile.ProducerProfile
import com.beatshare.beatshare.sharedPages.Search
import com.beatshare.beatshare.sharedPages.Settings

@ExperimentalFoundationApi
@Composable
fun MainContent(
    navController: NavHostController,
    artistsSignUpViewModel: ArtistsSignUpViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screen.LogIn.route
    ){
        composable(route = Screen.LogIn.route){
            LogIn(navController = navController)
        }
        composable(route = Screen.BeatsProducer.route){
            BeatsProducer(navController = navController)
        }
        composable(route = Screen.ArtistHome.route){
            ArtistsHome(navController = navController)
        }
        composable(route = Screen.ProducersHome.route){
            ProducersHome(navController = navController)
        }
        composable(route = Screen.ArtistVProducer.route){
           ArtistVProducer(navController = navController)
        }
        composable(route = Screen.ArtistSignUp.route){
            ArtistSignUp(navController = navController, artistsSignUpViewModel = artistsSignUpViewModel)
        }
        composable(route = Screen.ProducerSignUp.route){
           ProducerSignUp(navController = navController, artistsSignUpViewModel = artistsSignUpViewModel)
        }
        composable(route = Screen.ArtistSignUpCont.route){
            ArtistSignUpCont(navController = navController, artistsSignUpViewModel = artistsSignUpViewModel)
        }

        composable(route = Screen.GuestAccount.route){
            GuestAccount(navController = navController)
        }

        composable(route = Screen.ForgotPassword.route){
            ForgotPassword(navController = navController)
        }
        composable(route = Screen.ProducerSignUpCont.route){
            SignUpCont(navController = navController)
        }
        composable(route = Screen.UploadBeats.route){
            UploadBeats()
        }
        composable(route = Screen.DigitCode.route){
            DigitCode()
        }
        composable(route = Screen.PasswordReset.route){
            PasswordReset(navController = navController)
        }
        composable(route = Screen.Library.route){
            Library(artistsSignUpViewModel = artistsSignUpViewModel, navController = navController)
        }
        composable(route = Screen.ProducersProfile.route){
            ProducerProfile(navController = navController)
        }
        composable(route = Screen.Search.route){
            Search()
        }
        composable(route = Screen.Settings.route){
            Settings(navController = navController)
        }
    }
}
