package com.beatshare.beatshare.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

//Beats by Producers (still part of the home page, but to be accessed downwards as user
// scrolls to get more content)
//Some contents needs to be navigated from left to right
//This one now should be under Beatshare for Artists. Together with Home Page part 1 (for artists)

@Composable
fun Beats(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ){
        Text(text = "BEATS",fontSize = 50.sp, color = Color.White)
    }
}


@Composable
@Preview
fun beatPreview(){
    Beats(navController = rememberNavController())
}