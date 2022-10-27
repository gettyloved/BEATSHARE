package com.beatshare.beatshare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
private val artistsSignUpViewModel:ArtistsSignUpViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeatshareTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent(navController = rememberNavController(), artistsSignUpViewModel = artistsSignUpViewModel)
                }
            }
        }
    }
}




@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BeatshareTheme {
        MainContent(navController = rememberNavController(), artistsSignUpViewModel = ArtistsSignUpViewModel())
    }
}