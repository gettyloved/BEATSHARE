package com.beatshare.beatshare

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.beatshare.beatshare.home.ArtistsHome
import com.beatshare.beatshare.home.Beats
import com.beatshare.beatshare.home.ProducersHome
import com.beatshare.beatshare.login.ArtistSignUp
import com.beatshare.beatshare.login.ArtistSignUpCont
import com.beatshare.beatshare.login.ArtistVProducer
import com.beatshare.beatshare.login.LogIn
import com.beatshare.beatshare.sharedPages.Settings

@ExperimentalFoundationApi
@Composable
fun MainContent(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.LogIn.route
    ){
        composable(route = Screen.LogIn.route){
            LogIn(navController = navController)
        }
        composable(route = Screen.Beats.route){
            Beats(navController = navController)
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
            ArtistSignUp(navController = navController)
        }
        composable(route = Screen.ProducerSignUp.route){
           ProducersHome(navController = navController)
        }
        composable(route = Screen.ArtistSignUpCont.route){
            ArtistSignUpCont(navController = navController)
        }
    }
}
